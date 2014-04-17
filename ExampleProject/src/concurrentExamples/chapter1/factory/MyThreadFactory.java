package concurrentExamples.chapter1.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;
    
    public MyThreadFactory(String name){
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }
    
    @Override
    public Thread newThread(Runnable r) {
       Thread t = new Thread(r,name+"-Thread_" + counter);
       counter++;
       stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
       return t;
    }
    
    public String getStats(){
        StringBuffer buffer = new StringBuffer();
        for (String stat : stats){
            buffer.append(stat);
            buffer.append("\n");
        }
        return buffer.toString();
    }


}
