package org.learning.java.concurrency.print_foo_bar;

public class Main {
    public static void main(String[] args) {

        FooBar fooBar = new FooBar(3);

        Thread t1 = new FooBarThread(fooBar, "foo");
        Thread t2 = new FooBarThread(fooBar, "bar");

        t2.start();
        t1.start();
    }
}
