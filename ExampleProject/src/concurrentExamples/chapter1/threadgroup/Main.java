package concurrentExamples.chapter1.threadgroup;

import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i=0; i<5; i++){
            Thread thread = new Thread (threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.printf("Number of active Threads in the thread group: %d\n", threadGroup.activeCount());
        System.out.println("Infor about the Thread Group");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread thread : threads){
            System.out.printf("Thread %s: %s\n", thread.getName(), thread.getState());
        }
        
        waitFinish(threadGroup);
        threadGroup.interrupt();

    }
    
    private static void waitFinish(ThreadGroup threadGroup){
        while(threadGroup.activeCount() > 4 ){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
