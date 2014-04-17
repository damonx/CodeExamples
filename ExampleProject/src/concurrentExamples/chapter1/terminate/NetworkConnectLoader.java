package concurrentExamples.chapter1.terminate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectLoader implements Runnable {

    @Override
    public void run() {
        System.out.println("Network connection ...");
        try {
           TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.printf("Network sources loading has finished: %s\n", new Date());
    }
}
