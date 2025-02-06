package org.learning.java.concurrency.read_write_lock;

public class Main {
    public static void main(String args[]) throws Exception {

        final ReadWriteLock rwl = new ReadWriteLock();

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Attempting to acquire write lock in t1: " + System.currentTimeMillis());
                rwl.writeLockAcquire();
                System.out.println("write lock acquired t1: " + +System.currentTimeMillis());
                for (; ; ) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Attempting to acquire write lock in t2: " + System.currentTimeMillis());
                rwl.writeLockAcquire();
                System.out.println("write lock acquired t2: " + System.currentTimeMillis());
            } catch (InterruptedException ie) {

            }
        });

        Thread tReader1 = new Thread(() -> {
            try {
                rwl.readLockAqcuire();
                System.out.println("Read lock acquired: " + System.currentTimeMillis());
            } catch (InterruptedException ie) {

            }
        });

        Thread tReader2 = new Thread(() -> {
            System.out.println("Read lock about to release: " + System.currentTimeMillis());
            rwl.readLockRelease();
            System.out.println("Read lock released: " + System.currentTimeMillis());
        });

        tReader1.start();
        t1.start();
        Thread.sleep(3000);
        tReader2.start();
        Thread.sleep(1000);
        t2.start();
        tReader1.join();
        tReader2.join();
        t2.join();
    }
}
