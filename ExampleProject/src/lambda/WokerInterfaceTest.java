package lambda;

public class WokerInterfaceTest {

	public static void execute(WorkerInterface worker){
		worker.doSomework();
	}
	
	
	public static void main(String[] args) {
        execute(() -> System.out.println("Invoked using Lambda"));
	}

}
