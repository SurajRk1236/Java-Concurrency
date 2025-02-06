package org.learning.java.concurrency.basics_to_advance.executor_framework;

import java.util.concurrent.Executor;

public class ThreadExecutor {
    public static void main( String args[] ) {
        SomeExecutor myExecutor = new SomeExecutor();
        MyTask myTask = new MyTask();
        myExecutor.execute(myTask);
    }

    static class SomeExecutor implements Executor {
        public void execute(Runnable runnable) {
            Thread newThread = new Thread(runnable);
            newThread.start();
        }
    }

    static class MyTask implements Runnable {
        public void run() {
            System.out.println("Mytask is running now ...");
        }
    }
}
