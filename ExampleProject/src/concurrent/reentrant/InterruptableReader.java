package concurrent.reentrant;

public class InterruptableReader extends Thread{
    private BufferInterruptibly buff;
    
	public InterruptableReader(BufferInterruptibly buff) {
		this.buff = buff;
	}

    

	@Override
	public void run() {
       try {
		   buff.read();
		} catch (InterruptedException e) {
           System.out.println("I don't want to read any more...");
		}
        System.out.println("Reading is done.");
	}

}
