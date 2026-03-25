package br.univille.ExercThread4;

import java.util.ArrayList;
import java.util.Random;

public class Incluir implements Runnable {

    private ArrayList<Short> lista;

    public Incluir(ArrayList<Short> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!Thread.currentThread().isInterrupted()) {
            synchronized (lista) {
                lista.add((short) random.nextInt(1000));
            }
        }
    }
}
