package javaoopexample.closure;

public class Sub extends Base {
   private int temperature;
   
   private void adjustTemperature(int temperature){
	   this.temperature = temperature;
   }
   
   private class Closure implements Adjustable{
	   public void adjust(int temperature){
		   adjustTemperature(temperature);
	   }
   }
   
   public Adjustable getCallBackReference(){
	   return new Closure();
   }

@Override
public String toString() {
	return "Sub [temperature=" + temperature + " speed=" + getSpeed() + "]";
}
   
   
}
