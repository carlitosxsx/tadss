package br.univille.SimuladorBanco;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] cenarios = {1, 2, 3, 4, 5};

        for (int n : cenarios) {

            FilaClientes fila = new FilaClientes(1000);
            Registrador registros = new Registrador();

            Relogio.iniciar();

            GeradorClientes gerador = new GeradorClientes(fila);
            Thread tg = new Thread(gerador, "Gerador");
            tg.start();

            Thread[] atendentes = new Thread[n];

            for (int i = 0; i < n; i++) {
                Atendente a = new Atendente(fila, registros);
                atendentes[i] = new Thread(a, "Atendente-" + (i + 1));
                atendentes[i].start();
            }

            tg.join();

            for (Thread t : atendentes) {
                t.join();
            }

            registros.imprimir(n);
        }
    }
}