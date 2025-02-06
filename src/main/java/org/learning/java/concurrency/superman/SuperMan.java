package org.learning.java.concurrency.superman;

public class SuperMan {
    private static volatile SuperMan superman;

    private SuperMan() {

    }

    public static SuperMan getInstance() {

        if (superman == null) {
            synchronized (SuperMan.class) {
                if (superman == null) {
                    superman = new SuperMan();
                }
            }
        }

        return superman;
    }

    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
