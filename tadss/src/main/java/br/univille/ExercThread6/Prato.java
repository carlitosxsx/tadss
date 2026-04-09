package br.univille.ExercThread6;

public class Prato {
    private int id;
    private Estado estado;

    public Prato(int id, Estado estado) {
        this.id = id;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }
}
