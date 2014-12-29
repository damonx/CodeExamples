package suggestions.threads.locks;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TaskBase {
  public void doSomething(){
      try{
          TimeUnit.SECONDS.sleep(2);
      }catch(Exception e){
          
      }
      
      StringBuffer sb = new StringBuffer();
      sb.append(" Thread name: " + Thread.currentThread().getName());
      sb.append(", execution time: " + Calendar.getInstance().get(13) + " s");
      System.out.println(sb);
  }
}
