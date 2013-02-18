package javaoopexample.collection;

import java.util.*;

public class Visitor {
	public static void print(Collection<? extends Object> c) {
		Iterator<? extends Object> it = c.iterator();

		while (it.hasNext()) {
			Object element = it.next();
			System.out.println(element);
		}
	}

	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		set.add("Tom");
		set.add("Mary");
		set.add("Jack");
		print(set);

		List<String> list = new ArrayList<String>();
		list.add("Linda");
		list.add("Mary");
		list.add("Rose");
		print(list);

		Map<String, String> map = new HashMap<String, String>();
		map.put("M", "Male");
		map.put("F", "Female");
		print(map.entrySet());

	}
}
