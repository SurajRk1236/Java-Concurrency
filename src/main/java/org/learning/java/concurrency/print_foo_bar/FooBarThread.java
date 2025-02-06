package org.learning.java.concurrency.print_foo_bar;

public class FooBarThread extends Thread {
    private FooBar fooBar;
    private String method;
    public FooBarThread(FooBar fooBar, String method) {
        this.fooBar = fooBar;
        this.method = method;
    }

    public void run() {
        if ("foo".equals(method)) {
            fooBar.foo();
        }
        else if ("bar".equals(method)) {
            fooBar.bar();
        }
    }
}
