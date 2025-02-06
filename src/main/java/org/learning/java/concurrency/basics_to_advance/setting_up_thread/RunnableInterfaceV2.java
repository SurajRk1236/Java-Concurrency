package org.learning.java.concurrency.basics_to_advance.setting_up_thread;

public class RunnableInterfaceV2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        thread.join();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Created new thread");
    }
}
