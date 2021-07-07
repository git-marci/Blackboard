package ires.corso.partfour.concurrency.test01;

import java.util.concurrent.CountDownLatch;

public class TestRunnable implements Runnable
{
    /* Count latch test */
    private CountDownLatch latch = null; // Tutti aspettano il countdown

    /* Countdown */
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++; // NB: inizializza e chiude con final

    public TestRunnable(int countDown) {
        this.countDown = countDown;
    }

    public TestRunnable(int countDown, CountDownLatch cdl) {
        this.countDown = countDown;
        this.latch =  cdl;
    }

    public String status() {
        return ("[" + id + " ==> " + (countDown > 0? countDown: "END") + "] ");
    }

    @Override
    public void run()
    {
        if(latch != null) {
            System.out.println("[Starting thread with id == " + id + "]");
            latch.countDown(); 	// The last thread will open the barrier,
                                // and they will all restart at the same time
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        while(countDown-- > 0) {
            System.out.println(status());

            // Questo e' un suggerimento per il thread scheduler
            // di Java ==> indica che la parte importante dell'
            // esecuzione e' passata e  fornisce uno spunto per
            // il passaggio ad un altro thread
            Thread.yield();
        }
    }
}
