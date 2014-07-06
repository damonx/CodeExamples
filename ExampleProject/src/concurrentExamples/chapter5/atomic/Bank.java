package concurrentExamples.chapter5.atomic;

public class Bank implements Runnable {

    private Account account;
    
    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
       for (int i=0; i<10; i++){
           System.out.println("bankThread: " + Thread.currentThread().getName() + " is subtracting 1000.");
           account.substractAmount(1000);
           System.out.println("Account balance: (Bank)" + account.getBalance());
       }
    }

}
