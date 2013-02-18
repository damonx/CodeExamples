package javaoopexample.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapInterate {

	public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Monday");
        map.put("One", "Monday");
        
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
        	Map.Entry<String, String> entry = it.next();
        	System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("----------------");
        Set<String> keys = map.keySet();
        Iterator<String> it2 = keys.iterator();
        while(it2.hasNext()){
          String key = it2.next();
          String value = map.get(key);
          System.out.println(key + ":" + value);
        }
	}

}
