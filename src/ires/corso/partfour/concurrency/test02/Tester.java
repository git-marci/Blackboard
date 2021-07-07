package ires.corso.partfour.concurrency.test02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester
{
    private static int numOfInstances = 30;
    private static int threadSteps = 30;

    public static void main(String[] args)
    {
        CountDownLatch cdl = new CountDownLatch(numOfInstances);

        System.out.println("Starting CACHED thread pool test");
        System.out.println("");

        // Cached thread pool testing
        try {
            ExecutorService ctp = Executors.newCachedThreadPool();
            for(int i = 0; i < numOfInstances; i++)
                ctp.execute(new ThreadPoolRunnable(i + 1, numOfInstances, threadSteps, cdl));
            ctp.shutdown();
            while (!ctp.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS)) {
            }
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }

        /*
        System.out.println("");
        System.out.println("Starting FIXED thread pool test");
        System.out.println("");

        // Fixed thread pool testing
        try {
            ExecutorService ftp = Executors.newFixedThreadPool(10);
            for(int i = 0; i < numOfInstances; i++)
                ftp.execute(new ThreadPoolRunnable(i + 1, numOfInstances, threadSteps, null));
            ftp.shutdown();
            while (!ftp.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS)) {
            }
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        */
    }
}
