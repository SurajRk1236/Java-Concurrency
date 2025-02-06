package org.learning.java.concurrency.basics_to_advance.thread_pool_executor;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExec {
    public static void main(String args[]) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 1,
                TimeUnit.MINUTES, new SynchronousQueue());

        int i = 0;
        try {

            // Try to submit 50 tasks
            for (; i < 50; i++) {
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
        } catch (
                RejectedExecutionException ree) {
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
