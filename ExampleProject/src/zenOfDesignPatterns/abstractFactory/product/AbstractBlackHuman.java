package zenOfDesignPatterns.abstractFactory.product;

public abstract class AbstractBlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("Black human's skin is black.");

    }

    @Override
    public void talk() {
        System.out.println("Black human is speaking.");
    }

}
