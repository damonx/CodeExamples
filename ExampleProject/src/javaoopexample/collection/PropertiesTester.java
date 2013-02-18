package javaoopexample.collection;

import java.util.*;
import java.io.*;

public class PropertiesTester {
	public static void print(Properties ps) {
		Set<Object> keys = ps.keySet();
		Iterator<Object> it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = ps.getProperty(key);
			System.out.println(key + "=" + value);
		}
	}

	public static void main(String args[]) throws IOException {
		Properties ps = new Properties();
		InputStream in = PropertiesTester.class
				.getResourceAsStream("myapp.properties");
		ps.load(in);
		print(ps);

		ps = System.getProperties();
		print(ps);
	}
}
