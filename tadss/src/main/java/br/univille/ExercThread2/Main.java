package br.univille.ExercThread2;

public class Main /*extends Thread*/ implements Runnable{
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Contador: " + i);
        }
    }

    //thread de plataforma
    /*public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " - Número: "+ i);
        }
    }*/
    
    public static void main(String[] args) {
        // Faça um programa concorrente que crie 10 threads que exibam o nome da thread e um contador que varia de 1 a 10. Execute várias vezes e observe as variações na saída. Os valores são sempre impressos na mesma ordem?
        Main t2 = new Main();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = Thread.ofVirtual().name("Thread-" + i).start(t2); /*Java 19*/
        }
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }
    }
}
