package concurrent.reentrant;

public class InterruptableTest {


	public static void main(String[] args) {
        BufferInterruptibly buff = new BufferInterruptibly();
        final InterruptableWriter writer = new InterruptableWriter(buff);
        final InterruptableReader reader = new InterruptableReader(buff);
        
        writer.start();
        reader.start();
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
        		long start = System.currentTimeMillis();
        		for(;;){
        			if(System.currentTimeMillis() - start > 5000) {
        				System.out.println("Interrupt...");
        				reader.interrupt();
        				break;
        			}
        		}
			}
		}).start();
	}

}
