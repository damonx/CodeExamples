package concurrentExamples.chapter4.forkjoinpool;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
          ProductListGenerator generator = new ProductListGenerator();
          List<Product> products = generator.generate(10000);
          Task task = new Task(products, 0, products.size(), 0.20);
          ForkJoinPool pool = new ForkJoinPool();
          pool.execute(task);
          
          do{
              System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
              System.out.println("Main: Thread Steal: " + pool.getStealCount());
              System.out.println("Main: Prallelism: " + pool.getParallelism());
              try{
                  TimeUnit.MILLISECONDS.sleep(5);
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
          }while(!task.isDone());
          
          //shutdown pool.
          pool.shutdown();
          if(task.isCompletedNormally()){
              System.out.println("Main: The process has completed normally.");
          }
          
          for (Product prd : products){
              if (prd.getPrice() != 12){
                  System.out.printf("Product %s: %f\n", prd.getName(), prd.getPrice());
              }
          }
          
          System.out.println("Main: End of the program. \n");
          
          
    }

}
