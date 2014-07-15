package concurrentExamples.chapter6.executorThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
       MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
       ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
       
       MyTask task = new MyTask();
       executor.submit(task);
       
       executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: End of the program.");      
    }

}
