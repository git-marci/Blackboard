package ires.corso.partfour.concurrency.exceptions;

public class ThreadBreaker
{
    public void doSomethingThenBreak() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("...doing something: " + i);
        }
        throw new ThreadException("SOMETHING BAD HAPPENED IN THIS THREAD!!!", null);
    }
}
