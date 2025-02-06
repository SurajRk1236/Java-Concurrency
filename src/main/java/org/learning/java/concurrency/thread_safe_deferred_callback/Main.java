package org.learning.java.concurrency.thread_safe_deferred_callback;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        runtestForDeferredCallBack();
        runLateThenEarlyCallback();
    }

    private static void runtestForDeferredCallBack() throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();
        DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();
        Thread thread = new Thread(() -> {
            try {
                deferredCallbackExecutor.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread thread2 = new Thread(() -> {
                CallBack cb = new CallBack(1, "Hello this is " + Thread.currentThread().getName());
                deferredCallbackExecutor.registerCallback(cb);
            });
            thread2.setName("Thread_" + (i + 1));
            thread2.start();
            allThreads.add(thread2);
            Thread.sleep(1000);
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }

    public static void runLateThenEarlyCallback() throws InterruptedException {
        final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(() -> {
            try {
                deferredCallbackExecutor.start();
            } catch (InterruptedException ie) {
            }
        });

        service.start();

        Thread lateThread = new Thread(() -> {
            CallBack cb = new CallBack(8, "Hello this is the callback submitted first");
            deferredCallbackExecutor.registerCallback(cb);
        });
        lateThread.start();

        Thread.sleep(3000);

        Thread earlyThread = new Thread(() -> {
            CallBack cb = new CallBack(1, "Hello this is callback sumbitted second");
            deferredCallbackExecutor.registerCallback(cb);
        });
        earlyThread.start();

        lateThread.join();
        earlyThread.join();
    }


}
