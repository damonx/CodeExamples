package suggestions.threads.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskMain {

    public static void runTasks(Class<? extends Runnable> clz) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("***Beginning execution " + clz.getSimpleName() + " task*****");
        for (int i=0; i<3; i++){
            es.submit(clz.newInstance());
        }
        
        TimeUnit.SECONDS.sleep(10);
        System.out.println("-----" + clz.getSimpleName() + " task is done-----");
        es.shutdown();
    }
    public static void main(String[] args) throws Exception {
       runTasks(TaskWithLock.class);
       runTasks(TaskWithSync.class);
    }

}
