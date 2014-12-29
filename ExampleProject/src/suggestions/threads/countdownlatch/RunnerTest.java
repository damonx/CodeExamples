package suggestions.threads.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnerTest {

    static class Runner implements Callable<Integer> {
        private CountDownLatch begin;
        private CountDownLatch end;
        
        public Runner(CountDownLatch _begin, CountDownLatch _end){
            begin = _begin;
            end = _end;
        }
        
        @Override
        public Integer call() throws Exception {
            int score = new Random().nextInt(10);
            
            begin.await();
            TimeUnit.SECONDS.sleep(score);
            end.countDown();
            System.out.println("Thread: " + Thread.currentThread().getName() + " Score = " + score);
            return score;
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //ten persons  
        int num = 10;
          
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(num);
        
        ExecutorService es = Executors.newFixedThreadPool(num);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i<num; i++){
            futures.add(es.submit(new Runner(begin, end)));
        }
        
        begin.countDown();
        end.await();
        int count = 0;
        for (Future<Integer> f : futures){
            count += f.get();
        }
        System.out.println(" Average score: " + count/num);
        es.shutdown();
    }

}
