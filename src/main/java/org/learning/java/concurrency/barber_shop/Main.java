package org.learning.java.concurrency.barber_shop;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runTest();
    }

    public static void runTest() throws InterruptedException {
        HashSet<Thread> set = new HashSet<Thread>();
        final BarberShop barberShopProblem = new BarberShop();

        Thread barberThread = new Thread(() -> {
            try {
                barberShopProblem.barber();
            } catch (InterruptedException ie) {

            }
        });
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException ie) {

                }
            });
            set.add(t);
        }

        for (Thread t : set) {
            t.start();
        }

        for (Thread t : set) {
            t.join();
        }

        set.clear();
        Thread.sleep(800);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException ie) {

                }
            });
            set.add(t);
        }
        for (Thread t : set) {
            t.start();
        }

        barberThread.join();

    }
}
