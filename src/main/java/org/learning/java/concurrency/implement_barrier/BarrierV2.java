package org.learning.java.concurrency.implement_barrier;

public class BarrierV2 {

    int count = 0;
    int released = 0;
    int totalThreads;

    public BarrierV2(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {

        while (count == totalThreads)
            wait();

        count++;

        if (count == totalThreads) {
            notifyAll();
            released = totalThreads;
        } else {

            while (count < totalThreads)
                wait();
        }

        released--;
        if (released == 0) {
            count = 0;
            notifyAll();
        }
    }
}
