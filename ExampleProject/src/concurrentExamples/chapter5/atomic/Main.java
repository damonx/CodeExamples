package concurrentExamples.chapter5.atomic;

public class Main {

    
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        
        System.out.printf("Account: Initial Balance: %s\n", account.getBalance().toString());
        companyThread.start();
        bankThread.start();
        
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final balance: %s\n",account.getBalance().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
