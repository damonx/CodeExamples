package javaoopexample.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {
  
	private static final ThreadLocal<GlobalConfig> threadConfig = new ThreadLocal<GlobalConfig>();
  
	private Properties properties = new Properties();
	
	private GlobalConfig(){
		try {
			InputStream in = getClass().getResourceAsStream("myapp.properties");
			properties.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException("Load configuration failed.");
		}
	}
	
	public static GlobalConfig getInstance(){
		GlobalConfig config = threadConfig.get();
		if (config == null){
			config = new GlobalConfig();
			threadConfig.set(config);
		}
		return config;
	}
	
	public Properties  getProperties(){
		return properties;
	}
}
