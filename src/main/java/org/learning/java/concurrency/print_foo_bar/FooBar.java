package org.learning.java.concurrency.print_foo_bar;

public class FooBar {
    private int n;
    private int flag = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() {

        for (int i = 1; i <= n; i++) {
            synchronized(this) {
                while (flag == 1) {
                    try {
                        this.wait();
                    }
                    catch (Exception e) {

                    }
                }
                System.out.println("Foo");
                flag = 1;
                this.notifyAll();
            }
        }
    }

    public void bar() {

        for (int i = 1; i <= n; i++) {
            synchronized(this) {
                while (flag == 0) {
                    try {
                        this.wait();
                    }
                    catch (Exception e) {

                    }
                }
                System.out.println("Bar");
                flag = 0;
                this.notifyAll();
            }
        }
    }
}
