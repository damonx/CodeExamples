package zenOfDesignPatterns.factory;

public class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("Yellow man");
    }

    @Override
    public void talk() {
        System.out.println("Yellow man talks.");
    }

}
