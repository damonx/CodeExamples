package concurrentExamples.chapter2.conditionlock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }
    
    public void insert(String line){
        lock.lock();
        try{
            while (buffer.size() == maxSize){
                space.await();
            }
            buffer.offer(line);
            System.out.println(Thread.currentThread().getName() + ": Inserted Line: " + buffer.size());
            lines.signalAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public String get(){
        String line = null;
        lock.lock();
        try{
            while ((0 == buffer.size()) && (hasPendingLines())){
                lines.await();
            }
            if (hasPendingLines()){
                line = buffer.poll();
                System.out.println(Thread.currentThread().getName() + ": Line Readed: " + buffer.size());
                space.signalAll();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        return line;
    }
    
    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }
    
    public boolean hasPendingLines(){
        return pendingLines || buffer.size()>0;
    }
    
}
