package concurrentExamples.chapter6.priorityExecutor;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,1,TimeUnit.SECONDS,new PriorityBlockingQueue<Runnable>());
        
        for (int i=0; i<8; i++){
            MyPriorityTask task = new MyPriorityTask("Task "+i, i);
            executor.execute(task);
        }
        
        executor.shutdown();
        
        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("Main: End of the program.");
    }

}
