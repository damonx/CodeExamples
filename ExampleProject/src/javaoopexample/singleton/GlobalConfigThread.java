package javaoopexample.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfigThread {
  
	private static final GlobalConfigThread INSTANCE = new GlobalConfigThread();
  
	private Properties properties = new Properties();
	
	private GlobalConfigThread(){
		try {
			InputStream in = getClass().getResourceAsStream("myapp.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException("Load configuration failed.");
		}
	}
	
	public static GlobalConfigThread getInstance(){
		return INSTANCE;
	}
	
	public Properties  getProperties(){
		return properties;
	}
}
