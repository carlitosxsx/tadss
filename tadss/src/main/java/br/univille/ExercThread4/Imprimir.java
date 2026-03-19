package br.univille.ExercThread4;

import java.util.ArrayList;

public class Imprimir implements Runnable{

    private ArrayList<Short> lista;

    public Imprimir(ArrayList<Short> lista){
        this.lista = lista;
    }

@Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(lista);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
    }
}
