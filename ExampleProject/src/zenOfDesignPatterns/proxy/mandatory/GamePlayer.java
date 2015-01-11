package zenOfDesignPatterns.proxy.mandatory;

public class GamePlayer implements IGamePlayer {
    private String name = "";
    private IGamePlayer proxy = null;
   
	public GamePlayer(String _name){
		    this.name = _name;
	}
	
	@Override
	public IGamePlayer getProxy() {
		this.proxy = new GamePlayerProxy(this);
		return this.proxy;
	}

    private boolean isProxy(){
       return this.proxy != null;
    }

	@Override
	public void login(String user, String password) {
		if (isProxy()){
			 System.out.println("login name: " + user + "Name: " + name + " login successful");
		}else{
			System.out.println("Please use the designated proxy class.");
		}
	} 

	@Override
	public void killBoss() {
		if(isProxy()){
			 System.out.println(this.name + " is killing the boss.");
		}else{
			System.out.println("Please use the designated proxy class.");
		}
      
	}

	@Override
	public void upgrade() {
		if(isProxy()){
			System.out.println(this.name + " upgraded! ");
		}else{
			System.out.println("Please use the designated proxy class.");
		}
       
	}

}
