package zenOfDesignPatterns.abstractFactory.factory;

import zenOfDesignPatterns.abstractFactory.product.FemaleBlackHuman;
import zenOfDesignPatterns.abstractFactory.product.FemaleWhiteHuman;
import zenOfDesignPatterns.abstractFactory.product.FemaleYellowHuman;
import zenOfDesignPatterns.abstractFactory.product.Human;

public class FemaleFactory implements HumanFactory {

    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }

}
