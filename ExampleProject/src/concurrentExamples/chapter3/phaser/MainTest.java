package concurrentExamples.chapter3.phaser;

import java.util.concurrent.Phaser;

public class MainTest {

    public static void main(String[] args) {
       Phaser phaser = new Phaser(3);
       
       FileSearch system = new FileSearch("/Users/damonx", "log", phaser);
       FileSearch apps = new FileSearch("/Users/my_cool_app", "log", phaser);
       FileSearch documents = new FileSearch("/Users/damonx/mongodb", "log", phaser);
       
       Thread systemThread = new Thread(system, "System");
       systemThread.start();
       
       Thread appsThread = new Thread(apps,"Apps");
       appsThread.start();
       
       Thread documentsThread = new Thread(documents, "Documents");
       documentsThread.start();
       
       try{
           systemThread.join();
           appsThread.join();
           documentsThread.join();
       }catch(InterruptedException e){
           e.printStackTrace();
       }
       
       System.out.println("Terminated: " + phaser.isTerminated());
       
    }

}
