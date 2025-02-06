package org.learning.java.concurrency.uber_ride_seating;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runTest();
    }

    public static void runTest() throws InterruptedException {


        final UberSeat uberSeatingProblem = new UberSeat();
        Set<Thread> allThreads = new HashSet<Thread>();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatDemocrat();
                } catch (InterruptedException ie) {
                    System.out.println("We have a problem");

                } catch (BrokenBarrierException bbe) {
                    System.out.println("We have a problem");
                }

            });
            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);

            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatRepublican();
                } catch (InterruptedException ie) {
                    System.out.println("We have a problem");

                } catch (BrokenBarrierException bbe) {
                    System.out.println("We have a problem");
                }
            });
            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(20);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}
