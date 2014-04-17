package concurrentExamples.chapter2.readwritelock;

public class Main {

    public static void main(String[] args) {
       PricesInfo pi = new PricesInfo();
       Reader readers[] = new Reader[5];
       Thread readerthreads[] = new Thread[5];
       for (int i=0; i<5; i++){
           readers[i] = new Reader(pi);
           readerthreads[i] = new Thread(readers[i]);
       }
       
       Writer writer = new Writer(pi);
       Thread writerthread = new Thread(writer);
       
       for (Thread rthread : readerthreads){
           rthread.start();
       }
       
       writerthread.start();
       
       
    }

}
