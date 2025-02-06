package org.learning.java.concurrency.basics_to_advance.thread_handling;

public class SleepingThreads {
    public static void main(String args[]) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();
        innerThread.join();
        System.out.println("Main thread exiting.");
    }

    static class ExecuteMe implements Runnable {

        public void run() {
            System.out.println("Hello. innerThread going to sleep");
            try {
                //here sleep function is called
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                // swallow interrupted exception
            }
        }
    }
}
