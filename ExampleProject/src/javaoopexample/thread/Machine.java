package javaoopexample.thread;

import java.util.Timer;
import java.util.TimerTask;

public class Machine extends Thread {

    private int a;
    private static int count;
    
    
    
	@Override
	public synchronized void start() {
		super.start();
		Timer timer = new Timer(true);
		TimerTask  task = new TimerTask(){
			public void run(){
				
			   while(true){
			     reset();
			     System.out.println(getName() + "-->" + a);
                 try {
					sleep(3000);
				} catch (InterruptedException e) {
                    
				}
			   }
			}
		};
		
		timer.schedule(task, 30000, 30000);
	}
	
	private void reset(){
		a=0;
	}



	@Override
	public void run() {
        while(true){
        	System.out.println(getName() + ":" + a++);
        	//if(count++ == 10000) break;
        	try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	//yield();
        }
	}
	
	

	public static void main(String[] args) {
        Machine machine = new Machine();
        machine.start();
	}

}
