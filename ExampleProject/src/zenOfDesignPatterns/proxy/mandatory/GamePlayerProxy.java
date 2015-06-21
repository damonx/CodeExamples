package zenOfDesignPatterns.proxy.mandatory;

public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gameplayer = null;
    
    public GamePlayerProxy(IGamePlayer _gameplayer){
         this.gameplayer = _gameplayer;
    }
    
    
	@Override
	public IGamePlayer getProxy() {
		return this;
	}



	@Override
	public void login(String user, String password) {
       System.out.println("Proxy is logging for you!");
       gameplayer.login(user, password);
	}

	@Override
	public void killBoss() {
       System.out.println("Proxy is killing boss for you");
       gameplayer.killBoss();
	}

	@Override
	public void upgrade() {
		System.out.println("Proxy is upgrading for you.");
        gameplayer.upgrade();
	}

}
