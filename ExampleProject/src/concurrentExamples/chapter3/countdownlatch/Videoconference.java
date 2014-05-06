package concurrentExamples.chapter3.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.println(name + " has arrived.");
        controller.countDown();
        System.out.println("Video Conference Waiting for " + controller.getCount() + " participants.");
    }
    
    @Override
    public void run() {
        System.out.println("VideoConference: Initialization: " + controller.getCount() + " participants.");
        try{
            controller.await();
            System.out.println("VideoConference: All the participants have come");
            System.out.println("VideoConference: Let's start...");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    

}
