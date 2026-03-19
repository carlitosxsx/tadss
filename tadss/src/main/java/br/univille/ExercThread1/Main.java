package br.univille.ExercThread1;

import java.util.Date;

public class Main /*extends Thread*/ implements Runnable{
    public void run() {
            System.out.println(/*getName() + " - " + new Date()*/ Thread.currentThread().getName() + " - " + new Date());
    }

    public static void main(String[] args) {
        // Faça um programa concorrente que crie 10 threads que exibam o nome da thread e a hora atual.
        for (int i = 1; i <= 10; i++) {
            Main t1 = new Main();
            Thread.ofPlatform().start(t1); /*Java 19*/
            /*new Thread(t1).start();*/
            /*t1.start();*/
        }
    }
}
