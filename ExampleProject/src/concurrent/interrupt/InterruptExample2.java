package concurrent.interrupt;

class InterruptExample2 extends Thread {
	volatile boolean stop = false;

	public static void main(String args[]) throws Exception {
		InterruptExample2 thread = new InterruptExample2();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit( 0 );
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000) && (!stop)) {
			}
			//Comment out code could not interrupted via shared variable stop.
//			try {
//				sleep(100000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println("Thread exiting under request...");
	}
}
