package zenOfDesignPatterns.builder.after;

import java.util.ArrayList;
import java.util.List;

import zenOfDesignPatterns.builder.before.BenzModel;
import zenOfDesignPatterns.builder.before.BmwModel;
import zenOfDesignPatterns.builder.before.CarModel;

public class Director {
    private List<String> sequence = new ArrayList<>();
    private CarBuilder benzBuilder = new BenzBuilder();
    private CarBuilder bmwBuilder = new BmwBuilder();
    
    public CarModel getABenzModel(){
    	this.sequence.clear();
    	this.sequence.add("start");
    	this.sequence.add("stop");
    	this.benzBuilder.setSequence(sequence);
    	return (BenzModel)this.benzBuilder.getCarModel();
    }
    
    public CarModel getBBenzModel(){
    	this.sequence.clear();
    	this.sequence.add("engine boom");
    	this.sequence.add("start");
    	this.sequence.add("stop");
    	this.benzBuilder.setSequence(sequence);
    	return (BenzModel)this.benzBuilder.getCarModel();
    }
    
    public CarModel getCBmwModel(){
    	this.sequence.clear();
    	this.sequence.add("alarm");
    	this.sequence.add("start");
    	this.sequence.add("stop");
    	this.bmwBuilder.setSequence(sequence);
    	return (BmwModel)this.bmwBuilder.getCarModel();
    }
    
    public CarModel getDBmwModel(){
    	this.sequence.clear();
    	this.sequence.add("start");
    	this.bmwBuilder.setSequence(sequence);
    	return (BmwModel)this.bmwBuilder.getCarModel();
    }
    
    
}
