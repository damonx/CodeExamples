package concurrent.reentrant;

public class InterruptableWriter extends Thread {
    private BufferInterruptibly buff;
    
    public InterruptableWriter(BufferInterruptibly buff){
    	this.buff = buff;
    }
	
	@Override
	public void run() {
		buff.write();
	}

}
