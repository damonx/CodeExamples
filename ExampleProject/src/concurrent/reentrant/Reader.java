package concurrent.reentrant;

public class Reader extends Thread {
    
	private Buffer buff;
	
	
	
	public Reader(Buffer buff) {
		this.buff = buff;
	}



	@Override
	public void run() {
		buff.read();
	}



}
