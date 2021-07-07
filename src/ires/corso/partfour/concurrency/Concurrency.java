package ires.corso.partfour.concurrency;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency
{
    /*
        1. Running Tasks
        ----------------
        In Java, the Runnable interface describes a task you want to run, perhaps concurrently with others.

        public interface Runnable {
            void run();
        }

        Like all methods, the run method is executed in a thread.

        If you want to execute a Runnable in a separate thread, you could spawn a thread just for this
        Runnable. But in practice, it doesn’t usually make sense to have a one-to-one relationship between
        tasks and threads.
        When tasks are short-lived, you want to run many of them on the same thread, so you don’t waste the
        time it takes to start a thread.

        It is best to separate tasks and task scheduling.
     */

    public static void main(String[] args)
    {
        Runnable hellos = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("[Hello! " + i);
        };
        Runnable goodbyes = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("________________________ Goodbye " + i + "]");
        };

        Thread t1 = new Thread(hellos);
        Thread t2 = new Thread(goodbyes);

        // DON'T CALL THREAD RUN METHOD (altrimenti si rimane nel thread principale)

        //t1.start();
        //t2.start();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goodbyes);
    }
}
