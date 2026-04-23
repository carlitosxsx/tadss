package br.univille.SimuladorBanco;

public class Relogio {

    private static long inicio;
    private static int fator = 10; 
    public static void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public static long tempoAtual() {
        return (System.currentTimeMillis() - inicio) / fator;
    }
}