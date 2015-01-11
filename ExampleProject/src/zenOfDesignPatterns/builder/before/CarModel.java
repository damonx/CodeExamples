package zenOfDesignPatterns.builder.before;

import java.util.ArrayList;
import java.util.List;

public abstract class CarModel {
   private List<String> sequence = new ArrayList<>();
   protected abstract void start();
   protected abstract void stop();
   protected abstract void alarm();
   protected abstract void engineBoom();
   
   final public void run(){
	   for (int i=0; i<this.sequence.size(); i++){
		   String actionName = this.sequence.get(i);
		   if ("start".equalsIgnoreCase(actionName)){
			   this.start();
		   }else if ("stop".equalsIgnoreCase(actionName)){
			   this.stop();
		   }else if ("alarm".equalsIgnoreCase(actionName)){
			   this.alarm();
		   }else if ("engine boom".equalsIgnoreCase(actionName)){
			   this.engineBoom();
		   }else{
			   System.out.println("Wrong action");
		   }
	   }
   }
   
   final public void setSequence(List<String> sequence){
	   this.sequence = sequence;
   }
}
