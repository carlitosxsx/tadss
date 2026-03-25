package br.univille.ExercThread4;

import java.util.ArrayList;
/*COLLECION NÃO SÃO THREADSAFE*/
public class Main {
    public static void main(String[] args) {

        ArrayList<Short> lista = new ArrayList<Short>();
        Thread.ofPlatform().start(new Incluir(lista));
        Thread.ofPlatform().start(new Incluir(lista));
        Thread.ofPlatform().start(new Remover(lista));
        Thread.ofPlatform().start(new Imprimir(lista));
        System.out.println(lista);

    }
}
