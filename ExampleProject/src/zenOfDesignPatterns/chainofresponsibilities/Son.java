package zenOfDesignPatterns.chainofresponsibilities;

public class Son extends Handler {
	
	public Son() {
		super(SON_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("----- Mom is requesting to her son ----");
        System.out.println(women.getRequest());
        System.out.println("Repied from the son: Agreed!");
	}

}
