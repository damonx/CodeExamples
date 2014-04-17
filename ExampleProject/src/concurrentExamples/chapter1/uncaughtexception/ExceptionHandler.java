package concurrentExamples.chapter1.uncaughtexception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {
    
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An Exception has been captured.");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass(), e.getMessage());
        System.out.println("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", t.getState());
    }

}
