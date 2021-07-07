package ires.corso.partfour.concurrency.exceptions;

// UNCHECKED EXCEPTION!
public class ThreadException extends RuntimeException
{
    public ThreadException(String msg, Throwable err) {
        super(msg, err);
    }
}
