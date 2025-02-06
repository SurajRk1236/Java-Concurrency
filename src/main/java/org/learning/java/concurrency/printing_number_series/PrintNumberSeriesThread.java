package org.learning.java.concurrency.printing_number_series;

public class PrintNumberSeriesThread extends Thread {
    PrintNumberSeries zeo;
    String method;

    public PrintNumberSeriesThread(PrintNumberSeries zeo, String method){
        this.zeo = zeo;
        this.method = method;
    }

    public void run() {
        if ("zero".equals(method)) {
            try {
                zeo.PrintZero();
            }
            catch (Exception e) {
            }
        }
        else if ("even".equals(method)) {
            try {
                zeo.PrintEven();
            }
            catch (Exception e) {
            }
        }
        else if ("odd".equals(method)) {
            try {
                zeo.PrintOdd();
            }
            catch (Exception e) {
            }
        }
    }
}
