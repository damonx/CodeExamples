package concurrent.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread {
    Lock lock = new ReentrantLock();
    Condition mainCondition = lock.newCondition();
    Condition sub1Condition = lock.newCondition();
    Condition sub2Condition = lock.newCondition();
     volatile int flag = 1;
    public void main() {
         lock.lock();
         try {
              while (flag != 1) {
                   mainCondition.await();
              }
              for (int i = 1; i <= 5; i++) {
                   System.out.println(Thread.currentThread().getName() + " \t"
                             + i);
              }
              flag = 2;
              sub1Condition.signal();
         } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
         } finally {
              lock.unlock();
         }
    }
    public void sub1() {
         lock.lock();
         try {
              while (flag != 2) {
                   sub1Condition.await();
              }
              for (int i = 1; i <= 10; i++) {
                   System.out.println(Thread.currentThread().getName() + " \t"
                             + i);
              }
              flag = 3;
              sub2Condition.signal();
         } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
         } finally {
              lock.unlock();
         }
    }
    public void sub2() {
         lock.lock();
         try {
              while (flag != 3) {
                   sub2Condition.await();
              }
              for (int i = 1; i <= 15; i++) {
                   System.out.println(Thread.currentThread().getName() + " \t"
                             + i);
              }
              flag = 1;
              mainCondition.signal();
         } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
         } finally {
              lock.unlock();
         }
    }
} 

