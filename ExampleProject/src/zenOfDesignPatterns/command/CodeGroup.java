package zenOfDesignPatterns.command;

public class CodeGroup implements Group {

	@Override
	public void find() {
       System.out.println("Found code group...");
	}

	@Override
	public void add() {
       System.out.println("Add a new code");
	}

	@Override
	public void delete() {
       System.out.println("Delete a code");
	}

	@Override
	public void change() {
       System.out.println("Change a code");
	}

	@Override
	public void plan() {
      System.out.println("Change the code plans...");
	}

}
