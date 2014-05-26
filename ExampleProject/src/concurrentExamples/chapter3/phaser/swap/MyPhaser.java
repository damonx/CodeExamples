package concurrentExamples.chapter3.phaser.swap;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch(phase) {
            case 0: return statudentsArrived();
            case 1: return finishFirstExcercise();
            case 2: return finishSecondExcercise();
            case 3: return finishExam();
            default: return true;
        }
    }
   
    private boolean statudentsArrived(){
        System.out.println("Phaser: The exam are going to start. The students are ready.");
        System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
        return false;
    }

    private boolean finishFirstExcercise(){
        System.out.println("Phaser: All the students have finished the first excercise.");
        System.out.println("Phaser: It's time for the second one.");
        return false;
    }
    
    private boolean finishSecondExcercise(){
        System.out.println("Phaser: All the students have finished the second excercise.");
        System.out.println("Phaser: It's time for the third one.");
        return false;
    }
    
    private boolean finishExam(){
        System.out.println("Phaser: All the students have finished the exam.");
        System.out.println("Phaser: Thank you for your time.");
        return true;
    }
}
