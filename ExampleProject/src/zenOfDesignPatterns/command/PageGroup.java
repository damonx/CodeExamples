package zenOfDesignPatterns.command;

public class PageGroup implements Group {

	@Override
	public void find() {
       System.out.println("Found page group...");
	}

	@Override
	public void add() {
       System.out.println("Add a new page");
	}

	@Override
	public void delete() {
       System.out.println("Delete a page");
	}

	@Override
	public void change() {
       System.out.println("Change a page");
	}

	@Override
	public void plan() {
      System.out.println("Change the page plans...");
	}

}
