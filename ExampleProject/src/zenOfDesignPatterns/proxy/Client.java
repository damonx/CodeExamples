package zenOfDesignPatterns.proxy;

public class Client {
    public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("damonx");
		System.out.println("Start time: 9:45");
		player.login("damonx-username", "root");
		player.killBoss();
		player.upgrade();
		System.out.println("End time: 3:40");
	}
}
