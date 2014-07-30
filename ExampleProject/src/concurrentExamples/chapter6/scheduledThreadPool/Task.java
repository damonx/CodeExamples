package concurrentExamples.chapter6.scheduledThreadPool;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Task:Begin.");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Task: End.");
    }

}
