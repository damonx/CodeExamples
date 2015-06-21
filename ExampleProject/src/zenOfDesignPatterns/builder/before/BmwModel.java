package zenOfDesignPatterns.builder.before;

public class BmwModel extends CarModel {

	@Override
	protected void start() {
		System.out.println("Bmw is running like this...");

	}

	@Override
	protected void stop() {
		System.out.println("Bmw is ceasing like this...");

	}

	@Override
	protected void alarm() {
		System.out.println("Bmw horns like this...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("Bmw engine sounds like this...");

	}

}
