package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFibonacci {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFibonacci() throws InterruptedException, ExecutionException {
		System.out.println("\ntesting Fibonacci ...");
		final int num = 14; //For demo only
        ForkJoinTask<Integer> fjt = new Fibonacci(num);
        ForkJoinPool fjpool = new ForkJoinPool();
        Future<Integer> result = fjpool.submit(fjt);

        // do something
        System.out.println("Fibonacci(" + num + ") = " + result.get());
	}

}
