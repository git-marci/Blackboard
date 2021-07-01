package ires.corso.partfour;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BB210701
{
    public static void main(String[] args)
    {
        // Definiamo semplice Runnable
        Runnable r1 = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Runnable test " + i);
        };

        // Old style
        Runnable oldR1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 1000; i++)
                    System.out.println("________________________________OLD Runnable test " + i);
            }
        };

        /*
        OLD WAY...

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(oldR1);
        t1.start();
        t2.start();
        */

        // New classes!
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(r1);
        executor.execute(oldR1);
    }
}
