package zenOfDesignPatterns.abstractFactory.factory;

import zenOfDesignPatterns.abstractFactory.product.Human;

public interface HumanFactory {
   public Human createYellowHuman();
   public Human createWhiteHuman();
   public Human createBlackHuman();
}
