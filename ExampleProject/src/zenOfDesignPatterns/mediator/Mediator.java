package zenOfDesignPatterns.mediator;

public class Mediator extends AbstractMediator {

	@Override
	public void execute(String str, Object... objects) {
        if ("purchase.buy".equals(str)){
        	buyComputer((Integer)objects[0]);
        }else if ("sale.sell".equals(str)){
        	sellComputer((Integer)objects[0]);
        }else if ("sale.offsell".equals(str)){
        	offSell();
        }else if ("sale.clear".equals(str)){
        	clearStock();
        }
	}
	
	private void buyComputer(int number){
	    int saleStatus = super.sale.getSalesStatus();
	    if (saleStatus > 80){
	    	System.out.println("Purchased IBM computer: " + number);
	    	super.stock.increase(number);
	    }else{
	    	int buyNumber = number/2;
	    	System.out.println("Purchased IBM computer: " + buyNumber);
	    	super.stock.increase(buyNumber);
	    }
	}
	
	private void sellComputer(int number){
		if (super.stock.getStockNumber() < number){
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}
	
	private void offSell(){
		System.out.println("Off sold IBM computer: " + stock.getStockNumber());
	}
	
	private void clearStock(){
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}

}
