package org.learning.java.concurrency.basics_to_advance.setting_up_thread;

public class SubclassThread {


    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();

    }
}

class ExecuteMe extends Thread {
    public void run() {
        System.out.println("SubclassThread");
    }
}
