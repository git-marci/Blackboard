package ires.corso.partfour.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Tester
{
    public static void main(String[] args)
    {
        int BOUND = 10;
        int N_PRODUCERS = 4;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Starting with " + N_PRODUCERS + " producers and " + N_CONSUMERS + " consumers...");
        System.out.println("Each producer will insert " + poisonPillPerProducer + " poison pills");

        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i = 1; i < N_PRODUCERS + 1; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }
        //new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();

        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }
    }
}
