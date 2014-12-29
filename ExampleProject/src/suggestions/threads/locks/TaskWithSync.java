package suggestions.threads.locks;

public class TaskWithSync extends TaskBase implements Runnable {

    @Override
    public void run() {
       synchronized ("A") {
          doSomething(); 
       }
    }

}
