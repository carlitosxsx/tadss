package br.univille;

public class Main {
    public static void main(String[] args) {
        // Faça um programa concorrente que crie 10 threads que exibam o nome da thread e a hora atual.
        for (int i = 1; i <= 10; i++) {
            ExercThread1 t1 = new ExercThread1();
            Thread.ofPlataform().start(t1); /*Java 19*/
            /*new Thread(t1).start();*/
            /*t1.start();*/
        }
        // Faça um programa concorrente que crie 10 threads que exibam o nome da thread e um contador que varia de 1 a 10. Execute várias vezes e observe as variações na saída. Os valores são sempre impressos na mesma ordem?
            ExercThread2 t2 = new ExercThread2();
            Thread[] = threads = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads[i] = Thread.ofVirtual.start(t2); /*Java 19*/
            }
            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {}
            }
    }
}