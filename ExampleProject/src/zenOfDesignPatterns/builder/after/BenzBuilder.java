package zenOfDesignPatterns.builder.after;

import java.util.List;

import zenOfDesignPatterns.builder.before.BenzModel;
import zenOfDesignPatterns.builder.before.CarModel;

public class BenzBuilder extends CarBuilder {
	private CarModel benz = new BenzModel();

	@Override
	public void setSequence(List<String> sequence) {
         this.benz.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return this.benz;
	}

}
