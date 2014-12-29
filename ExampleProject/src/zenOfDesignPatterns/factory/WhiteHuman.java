package zenOfDesignPatterns.factory;

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("White man");
    }

    @Override
    public void talk() {
        System.out.println("White man talks.");
    }

}
