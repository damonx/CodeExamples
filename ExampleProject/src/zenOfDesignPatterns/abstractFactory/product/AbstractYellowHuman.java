package zenOfDesignPatterns.abstractFactory.product;

public abstract class AbstractYellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("Yellow human's skin is Yellow.");

    }

    @Override
    public void talk() {
        System.out.println("Yellow human is speaking.");
    }


}
