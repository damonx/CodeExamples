package concurrentExamples.chapter1.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
    private static InheritableThreadLocal<Date> startDate = new InheritableThreadLocal<Date>(){
        @Override protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread()
                .getId(), startDate.get());
        try {
           TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s: %s\n", Thread.currentThread().getId(), startDate.get());
    }

}
