package concurrent;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    private int compute(int small) {
        final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return results[small];
    }

    public Integer compute() {
        if (n <= 10) {
            return compute(n);
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        Fibonacci f2 = new Fibonacci(n - 2);
        System.out.println("fork new thread for " + (n - 1));
        f1.invoke();
        System.out.println("fork new thread for " + (n - 2));
        f2.invoke();
        return f1.join() + f2.join();
    }
}
