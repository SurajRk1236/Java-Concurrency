package org.learning.java.concurrency.dining_philosphers;

import static org.learning.java.concurrency.dining_philosphers.DiningPhilosopher.startPhilosoper;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runTest();
    }

    public static void runTest() throws InterruptedException {
        final DiningPhilosopher dp = new DiningPhilosopher();

        Thread p1 = new Thread(() -> startPhilosoper(dp, 0));

        Thread p2 = new Thread(() -> startPhilosoper(dp, 1));

        Thread p3 = new Thread(() -> startPhilosoper(dp, 2));

        Thread p4 = new Thread(() -> startPhilosoper(dp, 3));

        Thread p5 = new Thread(() -> startPhilosoper(dp, 4));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
    }
}
