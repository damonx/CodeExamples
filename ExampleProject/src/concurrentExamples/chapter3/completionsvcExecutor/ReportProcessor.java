package concurrentExamples.chapter3.completionsvcExecutor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcessor implements Runnable {
    private CompletionService<String> service;
    private boolean end;
    
    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
       while(!end){
           try{
               Future<String> result = service.poll(20,TimeUnit.SECONDS);
               if(result != null){
                   String report = result.get();
                   System.out.println("ReportReceiver: Report Received: " + report);
               }
           }catch( InterruptedException | ExecutionException e){
               e.printStackTrace();
           }
       }
    }
    
    public void setEnd(boolean end){
        this.end = end;
    }

}
