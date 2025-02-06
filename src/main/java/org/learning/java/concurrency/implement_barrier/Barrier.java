package org.learning.java.concurrency.implement_barrier;

import java.util.concurrent.Semaphore;

public class Barrier {
    Semaphore semaphore;
    int macCapacity;

    public Barrier(int capacity) {
        this.semaphore = new Semaphore(capacity);
        this.macCapacity = capacity;
    }

    public synchronized void acquireBarrier() throws InterruptedException {
        semaphore.acquire();
        if(semaphore.availablePermits() == 0) {
            semaphore.release(macCapacity);
        }
    }
}
