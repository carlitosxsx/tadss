package br.univille;

public class ExercThread1 /*extends Thread*/ implements Runnable{
    @Override
    public void run() {
            System.out.println(/*getName() + " - " + new Date()*/ Thread.currentThread().getName() + " - " + new Date());
    }
}
