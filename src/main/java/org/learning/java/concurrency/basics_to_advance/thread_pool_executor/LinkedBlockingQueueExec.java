package org.learning.java.concurrency.basics_to_advance.thread_pool_executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueExec {
    public static void main( String args[] ) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>());

        int i = 0;
        try {

            // Try to submit 20 tasks
            for (; i < 20; i++) {
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // simulate work by sleeping for 1 second
                            System.out.println("Thread " + Thread.currentThread().getName() + " at work.");
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                            // ignore for now
                        }
                    }
                });
            }
        } catch (RejectedExecutionException ree) {
            // Let's see which task gets rejected
            System.out.println("Task " + (i + 1) + " rejected.");
        } finally {
            // don't forget to shutdown the executor
            threadPoolExecutor.shutdown();

            // wait for the executor to shutdown
            threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
        }
    }
}
