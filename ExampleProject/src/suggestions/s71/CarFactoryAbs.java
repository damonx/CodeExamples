package suggestions.s71;

public enum CarFactoryAbs {
   FordCar{
       public Car create(){
           return new FordCar();
       }
   }, 
   BuickCar{
       public Car create(){
           return new BuickCar();
       }
   };
   
   public abstract Car create();
}