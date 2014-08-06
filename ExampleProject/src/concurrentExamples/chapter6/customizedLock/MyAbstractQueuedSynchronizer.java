package concurrentExamples.chapter6.customizedLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@SuppressWarnings("serial")
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
    private AtomicInteger state;
    
    public MyAbstractQueuedSynchronizer(){
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        // TODO Auto-generated method stub
        return state.compareAndSet(1, 0);
    }
    
    
}
