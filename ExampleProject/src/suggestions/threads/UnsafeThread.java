package suggestions.threads;

public class UnsafeThread implements Runnable {
    private volatile int count = 0;
    
    @Override
    public void run() {
        for (int i = 0; i<1000; i++){
            Math.hypot(Math.pow(92456789, i), Math.cos(i));
        }
        count++;
    }
    
    public int getCount(){
        return count;
    }

}
