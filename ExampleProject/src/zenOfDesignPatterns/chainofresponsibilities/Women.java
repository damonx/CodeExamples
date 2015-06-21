package zenOfDesignPatterns.chainofresponsibilities;

public class Women implements IWomen {
	
	private int type = 0;
	private String request = "";
	
	

	public Women(int type, String request) {
		this.type = type;
		switch (this.type) {
		case 1:
			this.request = "Daughter's request is: " + request;
			break;
		case 2:
			this.request = "Wife's request is: " + request;
			break;
		case 3:
			this.request = "Mom's request is: " + request;
			break;
		default:
			break;
		}
	}

	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public String getRequest() {
		return this.request;
	}

}
