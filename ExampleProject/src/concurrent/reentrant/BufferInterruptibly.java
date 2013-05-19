package concurrent.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class BufferInterruptibly {

	private ReentrantLock lock = new ReentrantLock();

	public void write() {
		lock.lock();
		try {
           long startTime = System.currentTimeMillis();
           System.out.println("Start to write data....");
           for (;;) {
        	   if(System.currentTimeMillis() - startTime > Integer.MAX_VALUE){
        		   break;
        	   }
           }
           System.out.println("Finally...");
           
		} finally {
           lock.unlock();
		}
	}
	
	public void read() throws InterruptedException{
		lock.lockInterruptibly();
		try{
			System.out.println("Reading data from the buffer");
		} finally {
			lock.unlock();
		}
	}

}
