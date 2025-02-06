package org.learning.java.concurrency.asynchronous_to_synchronous;

public class Main {
//    public static void main( String args[] ) throws Exception{
//        Executor executor = new Executor();
//        executor.asynchronousExecution(() -> {
//            System.out.println("I am done");
//        });
//
//        System.out.println("main thread exiting...");
//    }

    //Note how the main thread exits before the asynchronous execution is completed.
    //Your task is to make the execution synchronous without changing the original classes


    public static void main( String args[] ) throws Exception {
        SynchronousExecutor executor = new SynchronousExecutor();
        executor.asynchronousExecution(() -> System.out.println("I am done"));

        System.out.println("main thread exiting...");
    }
}
