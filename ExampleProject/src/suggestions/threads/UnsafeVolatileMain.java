package suggestions.threads;

public class UnsafeVolatileMain {
    
    public static void main(String[] args) throws Exception {
       int value = 1000;
       int loops = 0;
       
       ThreadGroup tg = Thread.currentThread().getThreadGroup();
       while (loops++ < value){
           UnsafeThread ut = new UnsafeThread();
           for (int i=0; i<value; i++){
               new Thread(ut).start();
           }
           
           do {
               Thread.sleep(15);
           }while(tg.activeCount() != 1);
           
           if (ut.getCount() != value){
               System.out.println("loop number: " + loops + " encountered unsafe situation.");
               System.out.println(" count = " + ut.getCount());
               System.exit(0);
           }
       }
    }

}
