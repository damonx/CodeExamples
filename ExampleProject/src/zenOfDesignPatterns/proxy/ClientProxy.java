package zenOfDesignPatterns.proxy;

public class ClientProxy {
    public static void main(String[] args) {
		IGamePlayer proxy = new GamePlayerProxy(new GamePlayer("damonx"));
	
		System.out.println("Start time: 9:45");
		proxy.login("damonx-username", "root");
		proxy.killBoss();
		proxy.upgrade();
		System.out.println("End time: 3:40");
	}
}
