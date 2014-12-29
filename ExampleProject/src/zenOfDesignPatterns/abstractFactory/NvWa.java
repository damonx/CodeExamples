package zenOfDesignPatterns.abstractFactory;

import zenOfDesignPatterns.abstractFactory.factory.FemaleFactory;
import zenOfDesignPatterns.abstractFactory.factory.HumanFactory;
import zenOfDesignPatterns.abstractFactory.factory.MaleFactory;
import zenOfDesignPatterns.abstractFactory.product.Human;

public class NvWa {

    public static void main(String[] args) {
        HumanFactory maleHumanFactory = new MaleFactory();
        HumanFactory femaleHumanFactory = new FemaleFactory();
        
        
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femalYellowHuman = femaleHumanFactory.createYellowHuman();
        
        System.out.println("Create a male yellow human.");
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
        
        System.out.println("Create a female yellow human");
        femalYellowHuman.getColor();
        femalYellowHuman.talk();
        femalYellowHuman.getSex();
    }

}
