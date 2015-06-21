package zenOfDesignPatterns.mediator;

import java.util.Random;

public class Sale extends AbstractColleage {

	public Sale(AbstractMediator mediator) {
		super(mediator);
	}
	
	public void sellIBMComputer(int number){
		super.mediator.execute("sale.sell", number);
		System.out.println("Sold IBM computer: " + number);
	}
	
	public int getSalesStatus(){
		Random rand = new Random(System.currentTimeMillis());
		int salesStatus = rand.nextInt(100);
		System.out.println("IBM computer sale status: " + salesStatus);
		return salesStatus;
	}
	
	public void offSale(){
		super.mediator.execute("sale.offsell");
	}

}
