package zenOfDesignPatterns.command;

public abstract class Command {
   protected RequirementGroup rg = new RequirementGroup();
   protected CodeGroup cg = new CodeGroup();
   protected PageGroup pg = new PageGroup();
   
   public abstract void execute();
}
