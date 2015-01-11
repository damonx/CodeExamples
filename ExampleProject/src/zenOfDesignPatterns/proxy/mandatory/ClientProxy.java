package zenOfDesignPatterns.proxy.mandatory;

public class ClientProxy {
    public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("damonx");
	    IGamePlayer proxy = player.getProxy();
		System.out.println("Start time: 9:45");
		proxy.login("damonx-username", "root");
		proxy.killBoss();
		proxy.upgrade();
		System.out.println("End time: 3:40");
	}
}
