package ires.corso.partfour.concurrency.banking;

import ires.corso.partfour.concurrency.banking.Bank;

public class BankAccount
{
    public static final int DELAY = 1000;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args)
    {
        var bank = new Bank(4, 100000);
        Runnable task1 = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException e)
            {
            }
        };

        Runnable task2 = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException e) {

                /*
                Thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted,
                either before or during the activity. Occasionally a method may wish to test whether the current
                thread has been interrupted, and if so, to immediately throw this exception.

                The following code can be used to achieve this effect:
                if (Thread.interrupted())  // Clears interrupted status!
                    throw new InterruptedException();
                */
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.setName("TRANSFER 0 ==> 1");
        t2.setName("TRANSFER 2 ==> 3");

        t1.start();
        t2.start();
    }
}