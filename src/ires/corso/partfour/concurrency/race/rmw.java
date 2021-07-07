package ires.corso.partfour.concurrency.race;

class Counter implements Runnable
{
    private int c = 0;

    public void increment() {
        try {
            Thread.sleep(1000); // Simula ritardo...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }

    @Override
    public void run()
    {
        System.out.println("Sono il Thread " + Thread.currentThread().getName() + " e sto eseguendo il metodo RUN");
        synchronized(this) {
            // prima aggiunge 1
            this.increment();
            System.out.println("Value for Thread " + Thread.currentThread().getName() + " after increment " + this.getValue());

            // poi toglie 1
            this.decrement();
            System.out.println("Value for Thread " + Thread.currentThread().getName() + " after decrement " + this.getValue());

            // IPOTETICAMENTE, se il metodo fosse perfettamente "parallelizzabile", ciascun thread vedrebbe 0 => 1 => 0
        }
    }
}

public class rmw
{
    public static void main(String[] args)
    {
        // Counter è Runnable ma anche lo SHARED STATE tra i 3 thread
        // (perchè i 3 thread accedono e modificano la stessa variabile
        // della stessa istanza)
        Counter counter = new Counter();

        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

