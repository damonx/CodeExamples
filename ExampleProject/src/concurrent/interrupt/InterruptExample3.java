package concurrent.interrupt;

class InterruptExample3 extends Thread {
	  volatile boolean stop = false;
	  public static void main( String args[] ) throws Exception {
	   InterruptExample3 thread = new InterruptExample3();
	   System.out.println( "Starting thread..." );
	   thread.start();
	   Thread.sleep( 3000 );
	   System.out.println( "Asking thread to stop..." );
	   thread.stop = true;
	   thread.interrupt();
	   Thread.sleep( 3000 );
	   System.out.println( "Stopping application..." );
	   //System.exit( 0 );
	  }
	  public void run() {
	    while ( !stop ) {
	     System.out.println( "Thread running..." );
	      try {
	      Thread.sleep( 1000 );
	      } catch ( InterruptedException e ) {
	      System.out.println( "Thread interrupted..." );
	      }
	    }
	   System.out.println( "Thread exiting under request..." );
	  }
	}


