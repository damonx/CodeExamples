package zenOfDesignPatterns.abstractFactory.factory;

import zenOfDesignPatterns.abstractFactory.product.Human;
import zenOfDesignPatterns.abstractFactory.product.MaleBlackHuman;
import zenOfDesignPatterns.abstractFactory.product.MaleWhiteHuman;
import zenOfDesignPatterns.abstractFactory.product.MaleYellowHuman;

public class MaleFactory implements HumanFactory {

    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }

}
