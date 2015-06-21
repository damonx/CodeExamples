package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class ThreadTestLambda {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("hello");
		new Thread(r).start();

		List<String> names = Arrays.asList("damon", "zoe", "ian");
		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

		names.stream().map(name -> name.toUpperCase())
				.forEach(System.out::println);

		List<String> lowerCaseNames = names.stream()
				.map(name -> name.toLowerCase()).collect(Collectors.toList());
		lowerCaseNames.forEach(System.out::println);

		String[] array = { "a", "b", "c" };
		for (int i = 1; i < 4; i++) {
			final int temp = i;
			Stream.of(array).map(item -> Strings.padEnd(item, temp, '@'))
					.forEach(System.out::println);
		}

		List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6, 5, 6);
		nums.stream().filter(num -> num != null).distinct()
				.forEach(System.out::println);
		System.out.println("------------------");
		Stream.generate(() -> Math.random());
		Stream.iterate(1, item -> item + 1).limit(10)
				.forEach(System.out::println);

		System.out.println("------------------");
		List<Integer> nums1 = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5,
				6, 7, 8, 9, 10);
		System.out.println("sum is:"
				+ nums1.stream().filter(num -> num != null).distinct()
						.mapToInt(num -> num * 2).peek(System.out::println)
						.skip(2).limit(4).sum());
		System.out.println("--------------FLAT MAP----");
		Stream<List<Integer>> integerListStream = Stream.of(
				Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));

		Stream<Integer> integerStream = integerListStream
				.flatMap((integerList) -> integerList.stream());
		integerStream.forEach(System.out::println);

		System.out.println("----------");
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("ints sum is:"
				+ ints.stream().reduce((sum, item) -> sum + item).get());

		System.out.println("----------");
		List<Integer> ints1 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> p = item ->  item < 100;
		System.out.println(ints1.stream().allMatch(p));
		ints1.stream().max((o1, o2) -> o1.compareTo(o2))
				.ifPresent(System.out::println);

	}

}
