package org.learning.java.concurrency.implement_semaphore;

public class CountSemaphore {
    int countPermit = 0;
    int maxPermit = 0;

    CountSemaphore(int maxPermit) {
        this.maxPermit = maxPermit;
    }

    synchronized void acquire() throws InterruptedException {
        while (countPermit == maxPermit) {
            wait();
        }
        countPermit++;
        notify();
    }

    synchronized void release() throws InterruptedException {
        while (countPermit == 0) {
            wait();
        }
        countPermit--;
        notify();
    }
}
