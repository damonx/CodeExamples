package suggestions.threads;

import java.lang.Thread.UncaughtExceptionHandler;

public class TcpServer implements Runnable {

    public TcpServer(){
        Thread t = new Thread(this);
        t.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
        t.start();
    }
    
    @Override
    public void run() {
         for (int i=0; i<3; i++){
             try{
                 Thread.sleep(1000);
                 System.out.println("System is running heathily: " + i);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
         }
         throw new RuntimeException();
    }
    
    private static class TcpServerExceptionHandler implements UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("thread " + t.getName() + "Exception...");
            e.printStackTrace();
            new TcpServer();
        }
        
    }
    

}
