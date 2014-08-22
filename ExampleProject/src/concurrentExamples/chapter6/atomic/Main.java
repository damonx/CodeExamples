package concurrentExamples.chapter6.atomic;

public class Main {

    public static void main(String[] args) throws Exception{
       ParkingCounter counter = new ParkingCounter(5);
       Sensor1 sensor1 = new Sensor1(counter);
       Sensor2 sensor2 = new Sensor2(counter);
       
       Thread thread1 = new Thread(sensor1);
       Thread thread2 = new Thread(sensor2);
       
       thread1.start();
       thread2.start();
       
       thread1.join();
       thread2.join();
       
       System.out.println("Main: Number of cars: " + counter.get());
       System.out.println("Main: End of the program.");
    }

}
