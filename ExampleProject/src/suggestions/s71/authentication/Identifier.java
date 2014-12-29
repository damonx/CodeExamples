package suggestions.s71.authentication;

public interface Identifier {
   String REFUSE_WORD = "You have no right to use the system.";
   public boolean identify();
}