package zenOfDesignPatterns.proxy.generic;

public class BeforeAdvice implements IAdvice {

	@Override
	public void exec() {
       System.out.println("I am pre-advice....");
	}

}
