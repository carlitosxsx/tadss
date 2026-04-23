package br.univille.SimuladorBanco;

public class FilaClientes {

    private Cliente[] clientes;
    private int inicio = 0;
    private int fimFila = 0;
    private int qtde = 0;
    private boolean fim = false;

    public FilaClientes(int tamanho) {
        clientes = new Cliente[tamanho];
    }

    public synchronized void adicionar(Cliente cliente) {

        while (qtde >= clientes.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        clientes[fimFila] = cliente;
        fimFila = (fimFila + 1) % clientes.length;
        qtde++;

        notifyAll();
    }

    public synchronized Cliente remover() {

        while (qtde == 0 && !fim) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (qtde > 0) {
            Cliente cliente = clientes[inicio];
            clientes[inicio] = null;

            inicio = (inicio + 1) % clientes.length;
            qtde--;

            notifyAll();
            return cliente;
        }

        return null;
    }

    public synchronized void setFim() {
        fim = true;
        notifyAll();
    }
}