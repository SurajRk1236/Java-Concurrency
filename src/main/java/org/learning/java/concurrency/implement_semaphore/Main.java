package org.learning.java.concurrency.implement_semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountSemaphore cs = new CountSemaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    cs.acquire();
                    System.out.println("Ping " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cs.release();
                    System.out.println("Pong " + i);
                } catch (InterruptedException ie) {

                }
            }
        });

        t2.start();
        t1.start();

        t1.join();
        t2.join();
    }
}
