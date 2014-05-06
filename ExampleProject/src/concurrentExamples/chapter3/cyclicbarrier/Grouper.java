package concurrentExamples.chapter3.cyclicbarrier;

public class Grouper implements Runnable {

    
    private Results results;
    
    public Grouper(Results resutls) {
        this.results = resutls;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: processing results...\n");
        int data[] = results.getData();
        for (int number : data){
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d\n", finalResult);
    }

}
