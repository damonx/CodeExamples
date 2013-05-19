package concurrent.reentrant;

public class Buffer{
	private Object lock = new Object();
	
	public Buffer(){
		
	}
	
	public void write(){
		synchronized (lock) {
			long startTime = System.currentTimeMillis();
			System.out.println("Start to write data into the buffer...");
			for(;;){
				if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE){
					break;
				}
			}
			System.out.println("Finally...it's done!");
		}
	}
	
	public void read(){
		synchronized (lock) {
			System.out.println("Reading data from the buffer...");
		}
	}
}