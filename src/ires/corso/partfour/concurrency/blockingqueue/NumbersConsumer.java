package ires.corso.partfour.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();

                // The important thing to remember is that we need to stop our consumer threads from waiting
                // for an element to appear in a queue indefinitely.
                // A good technique to signal from producer to the consumer that there are no more messages
                // to process is to send a special message called a poison pill. We need to send as many
                // poison pills as we have consumers.
                // Then when a consumer will take that special poison pill message from a queue, it will
                // finish execution gracefully.
                if (number.equals(poisonPill)) {
                    System.out.println("------------------------------------------------" + Thread.currentThread().getName() + " oh God I'm dying!");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " result: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}