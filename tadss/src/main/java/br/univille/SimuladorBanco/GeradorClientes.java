package br.univille.SimuladorBanco;

import java.util.Random;

public class GeradorClientes implements Runnable {

    private FilaClientes fila;
    private int duracao = 7200;
    private Random random = new Random();

    public GeradorClientes(FilaClientes fila) {
        this.fila = fila;
    }

    @Override
    public void run() {

        int id = 1;

        while (Relogio.tempoAtual() < duracao) {

            int intervalo = 5 + random.nextInt(46);

            try {
                Thread.sleep(intervalo * 10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            Cliente c = new Cliente(id++, Relogio.tempoAtual());
            fila.adicionar(c);

            System.out.println("Cliente chegou: " + c.getId());
        }

        fila.setFim();
        System.out.println("Gerador terminou");
    }
}