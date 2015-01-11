package zenOfDesignPatterns.proxy.dynamic;

public class GamePlayer implements IGamePlayer {
    private String name = "";
   
	public GamePlayer(String _name) {
		this.name = _name;
	}

	@Override
	public void login(String user, String password) {
       System.out.println("login name: " + user + "Name: " + name + " login successful");
	} 

	@Override
	public void killBoss() {
       System.out.println(this.name + " is killing the boss.");
	}

	@Override
	public void upgrade() {
       System.out.println(this.name + " upgraded! ");
	}

}
