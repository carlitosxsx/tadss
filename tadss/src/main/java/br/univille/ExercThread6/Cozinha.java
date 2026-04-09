package br.univille.ExercThread6;

public class Cozinha {

    public static void main(String[] args) {
        PilhaPratos sujos = new PilhaPratos(100);
        PilhaPratos escorredor = new PilhaPratos(10);
        PilhaPratos limpos = new PilhaPratos(100);

        for (int i = 0; i < sujos.getTamanho(); i++) {
            sujos.inserePrato(new Prato(i, Estado.SUJO));
        }

    }

}
