package br.univille.ExercThread6;

public class PilhaPratos {
    private Prato[] pratos;
    private int tamanho;

    public PilhaPratos(int tamanho) {
        pratos = new Prato[tamanho];
    }

    public void inserePrato(Prato prato) {
        pratos[tamanho] = prato;
        tamanho++;
    }

    public removerPrato() {
        tamanho--;
        Prato prato = pratos[tamanho];
        pratos[tamanho] = null;
        return;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
