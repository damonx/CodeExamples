package concurrentExamples.chapter5.priorityQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static void main(String[] args) {
       PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
       Thread taskThreads[] = new Thread[5];
       for (int i=0; i<taskThreads.length; i++){
           Task task = new Task(i,queue);
           taskThreads[i] = new Thread(task);
       }
       for (Thread t:taskThreads){
           t.start();
       }
       
       for (Thread t:taskThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
       }
       
       System.out.printf("Main: Queue Size: %d\n", queue.size());
       for (int i=0; i<taskThreads.length * 1000; i++){
           Event event = queue.poll();
           System.out.printf("Thread %s: Priority %d\n",event.getThread(),event.getPriority());
       }
       
       System.out.printf("Main: Queue Size: %d\n",queue.size());
       System.out.printf("Main: End of the program\n");
    }

}
