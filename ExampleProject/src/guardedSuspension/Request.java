package guardedSuspension;

public class Request {
	
	private String name;
	private Data response;
	
	public Request(String name) {
		this.name = name;
	}

	public synchronized Data getResponse() {
		return response;
	}

	public synchronized void setResponse(Data response) {
		this.response = response;
	}

	public  String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Request [name=" + name + "]";
	}

	
	

}
