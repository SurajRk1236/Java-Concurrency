package org.learning.java.concurrency.unisex_bathroom;

public class BathRoom {
    int noOfMembers = 0;
    int noOfFemaleMembers = 0;
    int noOfMaleMembers = 0;
    int maxNumberOfMembers = 3;

    public BathRoom(int maxNumberOfMembers) {
        this.maxNumberOfMembers = maxNumberOfMembers;
    }

    public synchronized void maleUseBathroom() throws InterruptedException {
        while (noOfMembers == maxNumberOfMembers || noOfFemaleMembers != 0) {
            wait();
        }
        noOfMaleMembers++;
        noOfMembers++;
    }

    public synchronized void removeMaleUseBathroom() throws InterruptedException {
        while (noOfMembers == 0) {
            wait();
        }
        noOfMembers--;
        noOfMaleMembers--;
        notifyAll();
    }

    public synchronized void feMaleUseBathroom() throws InterruptedException {
        while (noOfMembers == maxNumberOfMembers || noOfMaleMembers != 0) {
            wait();
        }
        noOfFemaleMembers++;
        noOfMembers++;
        notifyAll();
    }

    public synchronized void removeFemaleUseBathroom() throws InterruptedException {
        while (noOfMembers == 0) {
            wait();
        }
        noOfMembers--;
        noOfFemaleMembers--;
        notifyAll();
    }

}
