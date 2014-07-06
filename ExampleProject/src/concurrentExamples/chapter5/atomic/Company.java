package concurrentExamples.chapter5.atomic;

public class Company implements Runnable {

    private Account account;
    
    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
       for (int i=0; i<10; i++){
           System.out.println("Thread " + Thread.currentThread().getName() + " is adding 1000");
           account.addAmount(1000);
           System.out.println("Account balance: (Company)" + account.getBalance());
       }
    }

}
