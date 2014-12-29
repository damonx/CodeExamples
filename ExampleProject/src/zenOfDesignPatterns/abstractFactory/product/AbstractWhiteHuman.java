package zenOfDesignPatterns.abstractFactory.product;

public abstract class AbstractWhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("White human's skin is white.");

    }

    @Override
    public void talk() {
        System.out.println("White human is speaking.");
    }


}
