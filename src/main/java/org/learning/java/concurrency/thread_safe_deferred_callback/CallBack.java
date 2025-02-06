package org.learning.java.concurrency.thread_safe_deferred_callback;

public class CallBack {
    long executionAt;
    String message;

    public CallBack(long executionAt, String message) {
        this.executionAt = System.currentTimeMillis() + executionAt * 1000;
        this.message = message;
    }
}
