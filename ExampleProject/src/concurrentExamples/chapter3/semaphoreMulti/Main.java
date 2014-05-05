package concurrentExamples.chapter3.semaphoreMulti;

public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (Thread t : thread) {
            t.start();
        }
    }

}
