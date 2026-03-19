package br.univille.ExercThread4;

import java.util.ArrayList;

public class Remover implements Runnable {

    private ArrayList<Short> lista;

    public Remover(ArrayList<Short> lista) {
        this.lista = lista;
    }

    @Override
    public void run() { //busy wait
        while(!Thread.currentThread().isInterrupted()){
            if(!lista.isEmpty()){
                lista.removeFirst();
            }
        }
    }
}
