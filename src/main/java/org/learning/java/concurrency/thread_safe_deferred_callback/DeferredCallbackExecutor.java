package org.learning.java.concurrency.thread_safe_deferred_callback;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class DeferredCallbackExecutor {
    PriorityQueue<CallBack> queue = new PriorityQueue<>(
            (o1, o2) -> (int) (o1.executionAt - o2.executionAt));

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private long findSleepDuration() {
        long currentTime = System.currentTimeMillis();
        return queue.peek().executionAt - currentTime;
    }

    public void start() throws InterruptedException {
        long sleepDuration = 0;
        while (true) {
            lock.lock();
            while (queue.isEmpty()) {
                condition.await();
            }

            while (!queue.isEmpty()) {
                sleepDuration = findSleepDuration();
                if (sleepDuration <= 0) break;

                condition.await(sleepDuration, TimeUnit.MILLISECONDS);
            }

            CallBack cb = queue.poll();
            System.out.println(
                    "Executed at " + System.currentTimeMillis()/1000 + " required at " + cb.executionAt/1000
                            + ": message:" + cb.message);
            lock.unlock();
        }
    }

    public void registerCallback(CallBack cb) {
        lock.lock();
        queue.add(cb);
        condition.signal();
        lock.unlock();
    }
}
