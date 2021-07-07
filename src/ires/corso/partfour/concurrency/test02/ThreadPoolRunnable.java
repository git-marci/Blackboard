package ires.corso.partfour.concurrency.test02;

import java.util.concurrent.CountDownLatch;

public class ThreadPoolRunnable implements Runnable
{
    private int idx;
    private int steps;
    private StringBuffer strBuf = null;
    private CountDownLatch latch = null;

    @Override
    public void run()
    {
        try
        {
            if(latch != null) {
                System.out.println("[Starting thread with id == " + idx + "]");
                latch.countDown();
                latch.await();
            }

            for(int i = 0; i < steps; i++) {
                this.writeMsg();
                Thread.sleep(5);
                Thread.yield();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
    }

    public ThreadPoolRunnable(int index, int outOf, int stepNum, CountDownLatch cdl)
    {
        this.idx = index;
        this.steps = stepNum;
        this.latch = cdl;

        // Prepare string buffer for output
        this.strBuf = new StringBuffer("");
        strBuf.append("|");
        for(int i = 0; i < index - 1; i++)
            strBuf.append("  |");
        strBuf.append(String.format("%2d|", index));
        for(int i = index; i < outOf; i++)
            strBuf.append("  |");
    }

    private void writeMsg()
    {
        System.out.println(strBuf.toString());
    }
}
