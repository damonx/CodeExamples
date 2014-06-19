package concurrentExamples.chapter4.forkjoinmerge;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
       DocumentMock mock = new DocumentMock();
       String[][] document = mock.generateDocument(100, 1000, "hello");
       DocumentTask task = new DocumentTask(document,0,100,"hello");
       ForkJoinPool pool = new ForkJoinPool();
       pool.execute(task);
       
       do{
           System.out.println("**************************************************");
           System.out.println("Main: Paralellism: " + pool.getParallelism());
           System.out.println("Main: Active Threads: " + pool.getActiveThreadCount());
           System.out.println("Main: Task Count: " + pool.getQueuedTaskCount());
           System.out.println("Main: Steal Count: " + pool.getStealCount());
           try{
               TimeUnit.SECONDS.sleep(1);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }while(!task.isDone());
       
       pool.shutdown();
       try{
           pool.awaitTermination(1, TimeUnit.DAYS);
       }catch(InterruptedException e){
           e.printStackTrace();
       }
       
       try{
           System.out.printf("Main: The word appears %d in the document",task.get());
       }catch (InterruptedException | ExecutionException e){
           e.printStackTrace();
       }
    }

}
