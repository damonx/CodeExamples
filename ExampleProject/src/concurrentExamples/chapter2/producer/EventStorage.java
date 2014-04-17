package concurrentExamples.chapter2.producer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        super();
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set(){
        if (storage.size()==maxSize){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("Set: " + storage.size());
        notifyAll();
    }
    
    
    public synchronized void get(){
        if (storage.size() == 0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Get: " + storage.size() + " " + ((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
