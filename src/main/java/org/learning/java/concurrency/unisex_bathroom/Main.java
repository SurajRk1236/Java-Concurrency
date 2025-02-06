package org.learning.java.concurrency.unisex_bathroom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runTest();
    }

    public static void runTest() throws InterruptedException {

        final UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread female1 = new Thread(() -> {
            try {
                unisexBathroom.femaleUseBathroom("F1");
            } catch (InterruptedException ie) {

            }
        });

        Thread male1 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("M1");
            } catch (InterruptedException ie) {

            }
        });

        Thread male2 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("M2");
            } catch (InterruptedException ie) {

            }
        });

        Thread male3 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("M3");
            } catch (InterruptedException ie) {

            }
        });

        Thread male4 = new Thread(() -> {
            try {
                unisexBathroom.maleUseBathroom("M4");
            } catch (InterruptedException ie) {

            }
        });

        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();

    }
}
