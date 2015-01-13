package zenOfDesignPatterns.chainofresponsibilities;

public class Husband extends Handler {
	
	public Husband() {
		super(HUSBAND_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("----- Wife is requesting to her husband ----");
        System.out.println(women.getRequest());
        System.out.println("Repied from the husband: Agreed!");
	}

}
