package suggestions.threads.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
    
    static class A {
        public synchronized void a1(B b) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " enter A.a1()");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
            System.out.println(name + " trying to invoke B.b2()");
            b.b2();
        }

        public synchronized void a2() {
            System.out.println("Entered A.a2()");
        }
    }

    static class B {
        private static Lock lock = new ReentrantLock();
        public synchronized void b1(A a) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " enter B.a1()");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
            System.out.println(name + " trying to invoke A.a2()");
            a.a2();
        }

        public void b2() {
            try {
                if(lock.tryLock(10, TimeUnit.SECONDS)){
                    System.out.println("Entered B.b2()");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
            
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();

        // Thread A
        new Thread(new Runnable() {

            @Override
            public void run() {
                a.a1(b);
            }
        }, "Thread A").start();

        // Thread B
        new Thread(new Runnable() {

            @Override
            public void run() {
                b.b1(a);
            }
        }, "Thread B").start();

    }

}
