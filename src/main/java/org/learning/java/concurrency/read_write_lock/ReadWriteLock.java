package org.learning.java.concurrency.read_write_lock;

public class ReadWriteLock {
    int noOfReaders = 0;
    boolean isWriteLocked = false;
    public void readWriteLock() {
    }

    public synchronized void readLockAqcuire() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }
        noOfReaders++;
        notify();
    }

    public synchronized void readLockRelease() {
        noOfReaders--;
        notify();
    }

    public synchronized void writeLockAcquire() throws InterruptedException {
        while (isWriteLocked || noOfReaders != 0) {
            wait();
        }
        isWriteLocked = true;
    }

    public synchronized void writeLockRelease() {
        isWriteLocked = false;
        notify();
    }
}
