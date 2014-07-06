package concurrentExamples.chapter5.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private AtomicLong balance;

    public AtomicLong getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = new AtomicLong(balance);
    }
   
    public void addAmount(long amount){
        this.balance.getAndAdd(amount);
    }
    
    public void substractAmount(long amount){
        this.balance.getAndAdd(-amount);
    }
}
