package org.learning.java.concurrency.basics_to_advance.thread_handling;
/**
 * the main thread exits right after starting the innerThread
 * Once it exits, the JVM also kills the spawned thread
 *
 *
 *
 *
 *
 * Note that in case a spawned thread isn’t marked as a daemon then even if the main thread finishes execution,
 * JVM will wait for the spawned thread to finish before tearing down the process.
 */



public class JoinThreads {
//    public static void main( String args[] ) throws InterruptedException {
//
//        ExecuteMe executeMe = new ExecuteMe();
//        Thread innerThread = new Thread(executeMe);
//        innerThread.setDaemon(true);
//        innerThread.start();
//    }

    //fix
    public static void main(String args[]) throws InterruptedException {

        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.setDaemon(true);
        innerThread.start();
        innerThread.join();
    }


    static class ExecuteMe implements Runnable {

        public void run() {
            while (true) {
                System.out.println("Say Hello over and over again.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    // swallow interrupted exception
                }
            }
        }
    }
}
