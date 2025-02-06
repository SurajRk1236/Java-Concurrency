package org.learning.java.concurrency.basics_to_advance.callable_interface;

import java.util.concurrent.Callable;

public class CallInterface {
    public static void main(String[] args) throws Exception {
        SumTask sumTask = new  SumTask(2);
        System.out.println(sumTask.call());
    }

    static class SumTask implements Callable<Integer> {

        int n;

        public SumTask(int n) {
            this.n = n;
        }

        public Integer call() throws Exception {

            if (n <= 0)
                return 0;

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            return sum;
        }
    }
}
