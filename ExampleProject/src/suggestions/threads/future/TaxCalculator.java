package suggestions.threads.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaxCalculator implements Callable<Integer> {
    
    private int seedMoney;
    public TaxCalculator(int _seedMoney){
        seedMoney = _seedMoney;
    }
    
    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        return seedMoney/10;
    }

}
