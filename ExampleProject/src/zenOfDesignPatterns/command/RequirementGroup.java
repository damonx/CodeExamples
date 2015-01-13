package zenOfDesignPatterns.command;

public class RequirementGroup implements Group {

	@Override
	public void find() {
       System.out.println("Found requirement group...");
	}

	@Override
	public void add() {
       System.out.println("Add a new requirement");
	}

	@Override
	public void delete() {
       System.out.println("Delete a requirement");
	}

	@Override
	public void change() {
       System.out.println("Change a requirement");
	}

	@Override
	public void plan() {
      System.out.println("Change the reqirement plans...");
	}

}
