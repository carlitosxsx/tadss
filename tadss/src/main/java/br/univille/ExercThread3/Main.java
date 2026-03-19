package br.univille.ExercThread3;

import java.util.Random;

public class Main implements Runnable {

    private int[] lista;
    private int inicio;
    private int fim;
    public long somaParcial = 0;

    public Main(int[] lista, int inicio, int fim) {
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

    public static void main(String[] args) throws InterruptedException {

        int[] lista = new int[1_000_000];
        Random random = new Random();

        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextInt();
        }

        // 1 - Some todos os valores de forma sequencial e meça o tempo de execução
        long inicio = System.nanoTime();

        long soma = 0;
        for (int i = 0; i < lista.length; i++) {
            soma += lista[i];
        }

        long fim = System.nanoTime();

        long tempoSequencial = (fim - inicio) / 1_000_000;

        System.out.println("Soma sequencial: " + soma);
        System.out.println("Tempo sequencial: " + tempoSequencial + " ms\n");

        // 2 - Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução (Threads de Plataforma)
        Somador.executarTeste(lista, 10, tempoSequencial, false);
        // 3 - Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução (Threads de Plataforma)
        Somador.executarTeste(lista, 100, tempoSequencial, false);

        // 5 - Execução com Threads Virtuais 
        Somador.executarTeste(lista, 10, tempoSequencial, true);
        Somador.executarTeste(lista, 100, tempoSequencial, true);

    }

}