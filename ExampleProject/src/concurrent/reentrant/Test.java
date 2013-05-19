package concurrent.reentrant;

public class Test {


	public static void main(String[] args) {
        Buffer buff = new Buffer();
        final Writer writer = new Writer(buff);
        final Reader reader = new Reader(buff);
        
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
