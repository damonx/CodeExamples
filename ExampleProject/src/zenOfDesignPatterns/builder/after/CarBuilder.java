package zenOfDesignPatterns.builder.after;

import java.util.List;

import zenOfDesignPatterns.builder.before.CarModel;

public abstract class CarBuilder {
    public abstract void setSequence(List<String> sequence);
    public abstract CarModel getCarModel();
}
