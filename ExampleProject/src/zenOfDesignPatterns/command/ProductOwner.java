package zenOfDesignPatterns.command;

public class ProductOwner {
  private Command command;
  
  public void setCommand(Command command){
	  this.command = command;
  }
  
  public void action(){
	  this.command.execute();
  }
}
