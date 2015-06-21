package lambda;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

public class PredicateExample {
	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		list.stream().filter(predicate).forEach(System.out::println);
	}

	public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        
        System.out.println("Print all numbers:");
        evaluate(list, (n)->true);
 
        System.out.println("Print no numbers:");
        evaluate(list, (n)->false);
 
        System.out.println("Print even numbers:");
        evaluate(list, (n)-> n%2 == 0 );
 
        System.out.println("Print odd numbers:");
        evaluate(list, (n)-> n%2 == 1 );
 
        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n)-> n > 5 );
	}

}
