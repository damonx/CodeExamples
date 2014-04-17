package concurrentExamples.chapter1.terminate;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread t1 = new Thread(dsLoader, "DataSourceThread");
        NetworkConnectLoader ncLoader = new NetworkConnectLoader();
        Thread t2 = new Thread(ncLoader, "NetworkConnectionLoaderThread");
        t1.start();
        t2.start();

        try {
          t1.join();
          t2.join();
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loaded: %s", new Date());
    }
}
