package br.univille;

public class ExercThread2 /*extends Thread*/ implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Contador: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    //thread de plataforma
    /*public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " - Número: "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
    */
}
