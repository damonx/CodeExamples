package suggestions.s71;

public class FactoryEnumMain {

    public static void main(String[] args) {
       Car buickcar = CarFactory.BuickCar.create();
       Car fordcar = CarFactoryAbs.FordCar.create();
    }

}
