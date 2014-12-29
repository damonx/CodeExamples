package suggestions.threads.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest {
    static class Worker implements Runnable{

        private CyclicBarrier cb;
        public Worker(CyclicBarrier _cb){
            cb = _cb;
        }
        
        @Override
        public void run() {
            try{
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "--reached the convene site.");
                cb.await();
                System.out.println(Thread.currentThread().getName() + "--Finished.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
         CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            
            @Override
            public void run() {
                 System.out.println("Tunnel is done...");                
            }
        });
         
         new Thread(new Worker(cb), "Worker1").start();
         new Thread(new Worker(cb), "Worker2").start();
    }

}
