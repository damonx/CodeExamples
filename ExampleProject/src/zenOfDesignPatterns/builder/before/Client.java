package zenOfDesignPatterns.builder.before;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
       CarModel benz = new BenzModel();
       List<String> sequence = new ArrayList<>();
       sequence.add("engine boom");
       sequence.add("start");
       sequence.add("stop");
       benz.setSequence(sequence);
       benz.run();
	}

}
