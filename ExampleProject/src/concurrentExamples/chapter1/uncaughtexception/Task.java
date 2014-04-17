package concurrentExamples.chapter1.uncaughtexception;

public class Task implements Runnable {

    @Override
    public void run() {
      int numero = Integer.parseInt("damonx");
      System.out.println("Number: " + numero);
    }

}
