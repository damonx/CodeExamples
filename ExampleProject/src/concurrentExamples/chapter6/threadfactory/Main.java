package concurrentExamples.chapter6.threadfactory;

public class Main {

    public static void main(String[] args) throws Exception {
      MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
      MyTask task = new MyTask();
      Thread thread = myFactory.newThread(task);
      thread.start();
      thread.join();
      
      System.out.println("Main: Thread info.");
      System.out.printf("%s\n", thread);
      System.out.println("Main: End of the example.");
    }

}
