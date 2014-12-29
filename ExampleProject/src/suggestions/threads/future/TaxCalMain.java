package suggestions.threads.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TaxCalMain {

 
    public static void main(String[] args) throws Exception{
       ExecutorService es = Executors.newSingleThreadExecutor();
       Future<Integer> future = es.submit(new TaxCalculator(100));
       while(!future.isDone()){
           TimeUnit.MILLISECONDS.sleep(200);
           System.out.print("#");
       }
       System.out.println("\n Calculation accomplished, tax is: " + future.get() + " Yuan");
       es.shutdown();
    }

}
