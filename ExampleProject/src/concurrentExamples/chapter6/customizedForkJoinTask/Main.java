package concurrentExamples.chapter6.customizedForkJoinTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
        int array[] = new int[1000];
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task("Task", array, 0,array.length );
        pool.invoke(task);
        pool.shutdown();
        try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("Main: end of the program.");
        
	}

}
