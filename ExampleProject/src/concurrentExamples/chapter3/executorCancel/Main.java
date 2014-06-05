package concurrentExamples.chapter3.executorCancel;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Executing the Task\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.printf("Main: Cancelling the Task\n");
        result.cancel(true);
        
        System.out.println("Main: Cancelled: " + result.isCancelled());
        System.out.println("Main: Done: " + result.isDone());
        
        executor.shutdown();
        System.out.println("Main: Theexecutor has finished.");
    }

}
