package concurrentExamples.chapter4.forkjoinasync;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
      ForkJoinPool pool = new ForkJoinPool();
      FolderProcessor system = new FolderProcessor("/System","log");
      FolderProcessor apps = new FolderProcessor("Applications", "log");
      FolderProcessor documents = new FolderProcessor("/Users/damonx/Documents", "pdf");
      
      pool.execute(system);
      pool.execute(apps);
      pool.execute(documents);
      
      do{
          System.out.println("**************************************************************************");
          System.out.println("Main: Parallelism: " + pool.getParallelism());
          System.out.println("Main: Active Threads: " + pool.getActiveThreadCount());
          System.out.println("Main: Task Count: " + pool.getQueuedTaskCount());
          System.out.println("Main: Steal Count: " + pool.getStealCount());
          System.out.println("**************************************************************************");
          
          try{
              TimeUnit.SECONDS.sleep(1);
          }catch(InterruptedException e){
              e.printStackTrace();
          }
      }while((!system.isDone()) ||  (!apps.isDone()) || (!documents.isDone()));
      
      pool.shutdown();
      
      List<String> results;
      results = system.join();
      System.out.printf("System: %d files found. \n",results.size());
      results = apps.join();
      System.out.printf("Apps: %d files found \n",results.size());
      results = documents.join();
      System.out.printf("Document: %d files found \n",results.size());
    }

}
