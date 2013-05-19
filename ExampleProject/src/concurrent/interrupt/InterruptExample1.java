package concurrent.interrupt;

class InterruptExample1 extends Thread {
	boolean stop = false;

	public static void main(String args[]) throws Exception {
		InterruptExample1 thread = new InterruptExample1();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000)) {
			}
			//Code commented out can be interrupted via interrupt() method.
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
