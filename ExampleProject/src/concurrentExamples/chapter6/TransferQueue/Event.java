package concurrentExamples.chapter6.TransferQueue;

public class Event implements Comparable<Event> {
    private String thread;
    private int priority;
    
    public Event(String thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public String getThread(){
        return this.thread;
    }
    
    public int getPriority(){
        return this.priority;
    }
    
    @Override
    public int compareTo(Event o) {

        if (this.priority > o.getPriority()){
            return -1;
        } else if (this.priority < o.getPriority()){
            return 1;
        } else {
            return 0;
        }
    }

}
