package zenOfDesignPatterns.factory;

public class BlackHuman implements Human {

    @Override
    public void getColor() {
       System.out.println("Black person has black skin color.");
    }

    @Override
    public void talk() {
         System.out.println("YoYoYo,black");
    }

}
