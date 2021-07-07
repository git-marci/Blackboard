package ires.corso.partfour.concurrency.exceptions;

public class Tester
{
    public static void main(String[] args)
    {
        //badTest();
        betterTest();
    }

    public static void badTest()
    {
        //...old style
        Runnable oldR = new Runnable() {
            @Override
            public void run() {
                ThreadBreaker tb = new ThreadBreaker();
                tb.doSomethingThenBreak();
            }
        };

        // Equivalente
        Runnable r = () -> {
            ThreadBreaker tb = new ThreadBreaker();
            tb.doSomethingThenBreak();
        };

        Thread t = new Thread(r);

        try {
            t.start();
        }

        // QUESTO BLOCCO NON FUNZIONA!!!
        catch(Exception e) {
            System.out.println("ECCEZIONE::::> " + e.getMessage());
        }

        System.out.println("Io sono arrivato alla fine...");
    }

    public static void betterTest()
    {
        // Equivalente
        Runnable r = () -> {
            ThreadBreaker tb = new ThreadBreaker();
            tb.doSomethingThenBreak();
        };

        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ECCEZIONE::::> " + e.getMessage());
            }
        });
        t.start();

        for(int i = 0; i < 1000; i++)
            System.out.println("Anche io sono arrivato alla fine...");
    }
}

