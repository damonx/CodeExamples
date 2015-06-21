package zenOfDesignPatterns.builder.after;

import java.util.List;

import zenOfDesignPatterns.builder.before.BmwModel;
import zenOfDesignPatterns.builder.before.CarModel;

public class BmwBuilder extends CarBuilder {
	private CarModel bmw = new BmwModel();

	@Override
	public void setSequence(List<String> sequence) {
         this.bmw.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return this.bmw;
	}

}
