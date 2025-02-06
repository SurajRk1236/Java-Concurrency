package org.learning.java.concurrency.basics_to_advance.setting_up_thread;

public class RunnableInterface {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Created new thread");
        });
        thread.start();
        thread.join();
    }

}
