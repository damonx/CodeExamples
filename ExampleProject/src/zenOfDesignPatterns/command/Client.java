package zenOfDesignPatterns.command;

public class Client {

	public static void main(String[] args) {
       ProductOwner po = new ProductOwner();
       System.out.println("Client needs to add a new requirement");
       Command command = new AddRequirementCommand();
       po.setCommand(command);
       po.action();
       
       System.out.println("--------------------------------------");
       System.out.println("Client needs to delete a page");
       command = new DeletePageCommand();
       po.setCommand(command);
       po.action();
	}

}
