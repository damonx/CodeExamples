package zenOfDesignPatterns.builder.before;

public class BenzModel extends CarModel {

	@Override
	protected void start() {
		System.out.println("Benz is running like this...");

	}

	@Override
	protected void stop() {
		System.out.println("Benz is ceasing like this...");

	}

	@Override
	protected void alarm() {
		System.out.println("Benz horns like this...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("Benz's engine sounds like this...");

	}

}
