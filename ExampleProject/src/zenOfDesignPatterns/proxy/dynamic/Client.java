package zenOfDesignPatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
      IGamePlayer player = new GamePlayer("damonx");
      InvocationHandler handler = new GamePlayIH(player);
      
      System.out.println("Begin time: ---------");
      ClassLoader cl = player.getClass().getClassLoader();
      IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
      proxy.login("damonx", "password");
      proxy.killBoss();
      proxy.upgrade();
      System.out.println("End time: ---------");
	}

}
