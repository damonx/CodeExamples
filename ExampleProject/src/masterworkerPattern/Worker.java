package masterworkerPattern;

import java.util.Map;
import java.util.Queue;

public abstract class Worker implements Runnable {
	protected Queue<Object> workQueue;
	protected Map<String, Object> resultMap;

	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public abstract Object handle(Object input);

	@Override
	public void run() {
       while(true){
    	   Object input = workQueue.poll();
    	   if(input==null){
    		   break;
    	   }
    	   
    	   Object result = handle(input);
    	   resultMap.put(Integer.toString(input.hashCode()), result);
       }
	}

}