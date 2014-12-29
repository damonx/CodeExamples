package suggestions.s71;

public enum CarFactory {
   FordCar, BuickCar;
   
   public Car create(){
       switch(this){
         case FordCar: return new FordCar();
         case BuickCar: return new BuickCar();
         default: throw new AssertionError("Invalid parameter.");
       }
   }
}