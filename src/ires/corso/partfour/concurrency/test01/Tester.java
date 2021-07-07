package ires.corso.partfour.concurrency.test01;

import java.util.concurrent.CountDownLatch;

public class Tester
{
    // Using a CountDownLatch barrier...
    public static void main(String[] args)
    {
        System.out.println("Launching CDL threads...");
        CountDownLatch cdl = new CountDownLatch(5);
        for(int i = 0; i < 5; i++) {
            new Thread(new TestRunnable(10, cdl)).start();
        }
    }
}
