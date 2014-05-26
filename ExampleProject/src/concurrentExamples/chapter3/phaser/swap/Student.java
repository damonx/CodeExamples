package concurrentExamples.chapter3.phaser.swap;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam. %s\n", Thread
                .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        doExam("first");
        phaser.arriveAndAwaitAdvance();
        doExam("second");
        phaser.arriveAndAwaitAdvance();
        doExam("third");
        phaser.arriveAndAwaitAdvance();
    }

    private void doExam(String excerciseNumber) {
        System.out.printf("%s Is going to do the " + excerciseNumber
                + " excercise. %s\n", Thread.currentThread().getName(),
                new Date());
        if ("first".equals(excerciseNumber)) {
            doExcercise1();
        } else if ("second".equals(excerciseNumber)) {
            doExcercise2();
        } else {
            doExcercise3();
        }
        System.out.printf("%s has done the " + excerciseNumber
                + " excercise. %s\n", Thread.currentThread().getName(),
                new Date());
    }

    private void doExcercise1() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExcercise2() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExcercise3() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
