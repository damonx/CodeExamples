package suggestions.threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskWithLock extends TaskBase implements Runnable {

    private  final Lock lock = new ReentrantLock();
    
    @Override
    public void run() {
        try{
            lock.lock();
            doSomething();
        }finally{
            lock.unlock();
        }
    }

}
