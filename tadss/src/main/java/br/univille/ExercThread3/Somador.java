package br.univille.ExercThread3;

public class Somador implements Runnable {
    private int[] lista;
    private int inicio;
    private int fim;
    public long somaParcial = 0;

    public Somador(int[] lista, int inicio, int fim) {
        this.lista = lista;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            somaParcial += lista[i];
        }
    }

    public static void executarTeste(int[] lista, int nThreads, long tempoSequencial, boolean virtual)
            throws InterruptedException {

        Thread[] threads = new Thread[nThreads];
        Main[] tarefas = new Main[nThreads];

        int bloco = lista.length / nThreads;

        long inicio = System.nanoTime();

        for (int i = 0; i < nThreads; i++) {

            int inicioBloco = i * bloco;
            int fimBloco = (i == nThreads - 1) ? lista.length : inicioBloco + bloco;

            tarefas[i] = new Main(lista, inicioBloco, fimBloco);

            if (virtual) {
                threads[i] = Thread.ofVirtual().start(tarefas[i]);
            } else {
                threads[i] = Thread.ofPlatform().start(tarefas[i]);
            }
        }

        long somaTotal = 0;

        for (int i = 0; i < nThreads; i++) {
            threads[i].join();
            somaTotal += tarefas[i].somaParcial;
        }

        long fim = System.nanoTime();

        long tempoConcorrente = (fim - inicio) / 1_000_000;

        double speedup = (double) tempoSequencial / tempoConcorrente;

        String tipo = virtual ? "Threads Virtuais" : "Threads de Plataforma";

        System.out.println(tipo + " - " + nThreads + " threads");
        System.out.println("Tempo concorrente: " + tempoConcorrente + " ms");
        System.out.println("Speedup: " + speedup);

        if (speedup < 1) {
            System.out.println("Speedup negativo (execução mais lenta)");
        }

        System.out.println();

        /*4.1 e 4.2 - Durante as execuções utilizando threads de plataforma, foi observado que em 100% dos testes o speedup foi negativo.
        Isso significa que o tempo de execução da soma sequencial (sem uso de threads) foi menor do que o tempo utilizando múltiplas threads.*/

        /*5 - Durante os testes com threads virtuais, observou-se que ao utilizar 10 threads o speedup continuou sendo negativo.
        Entretanto, ao utilizar 100 threads virtuais, o speedup passou a ser positivo. Isso ocorre porque as threads virtuais são muito mais leves
        que as threads de plataforma, pois são gerenciadas pela própria JVM e não diretamente pelo sistema operacional*/
    }
}
