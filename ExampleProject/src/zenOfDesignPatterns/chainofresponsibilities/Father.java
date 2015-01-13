package zenOfDesignPatterns.chainofresponsibilities;

public class Father extends Handler {
	
	public Father() {
		super(FATHER_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("----- Daughter is requesting to her father ----");
        System.out.println(women.getRequest());
        System.out.println("Repied from the father: Agreed!");
	}

}
