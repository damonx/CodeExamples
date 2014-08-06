package concurrentExamples.chapter6.customizedForkJoinTask;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    
    private int array[];
    private int start,end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer ret = 1;
        MyWorkerThread thread = (MyWorkerThread)Thread.currentThread();
        thread.addTask();
        return ret;
    }

}
