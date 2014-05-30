package concurrentExamples.chapter3.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;
    public Server(){
        executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }
    
    public void executeTask(Task task){
        System.out.println("Server: A new task has arrived.");
        executor.execute(task);
        System.out.printf("Server: Pool size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
   
}
