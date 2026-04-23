package br.univille.SimuladorBanco;

import java.util.Random;

public class Atendente implements Runnable {

    private FilaClientes fila;
    private Registrador registros;
    private Random random = new Random();

    public Atendente(FilaClientes fila, Registrador registros) {
        this.fila = fila;
        this.registros = registros;
    }

    @Override
    public void run() {

        while (true) {

            Cliente c = fila.remover();

            if (c == null) {
                break;
            }

            c.setTempoInicioAtendimento(Relogio.tempoAtual());

            int tempoAtendimento = 30 + random.nextInt(90); // 30 a 120

            try {
                Thread.sleep(tempoAtendimento * 10); // acelerado
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            c.setTempoFimAtendimento(Relogio.tempoAtual());

            registros.registrar(c);

            System.out.println(Thread.currentThread().getName() + " atendeu cliente " + c.getId());
        }

        System.out.println(Thread.currentThread().getName() + " terminou");
    }
}
