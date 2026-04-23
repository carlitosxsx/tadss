package br.univille.SimuladorBanco;

public class Cliente {

    private int id;
    private long tempoChegada;
    private long tempoInicioAtendimento;
    private long tempoFimAtendimento;

    public Cliente(int id, long tempoChegada) {
        this.id = id;
        this.tempoChegada = tempoChegada;
    }

    public int getId() {
        return id;
    }

    public long getTempoChegada() {
        return tempoChegada;
    }

    public long getTempoInicioAtendimento() {
        return tempoInicioAtendimento;
    }

    public void setTempoInicioAtendimento(long tempoInicioAtendimento) {
        this.tempoInicioAtendimento = tempoInicioAtendimento;
    }

    public long getTempoFimAtendimento() {
        return tempoFimAtendimento;
    }

    public void setTempoFimAtendimento(long tempoFimAtendimento) {
        this.tempoFimAtendimento = tempoFimAtendimento;
    }
}