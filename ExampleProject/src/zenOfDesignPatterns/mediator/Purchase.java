package zenOfDesignPatterns.mediator;

public class Purchase extends AbstractColleage {

	public Purchase(AbstractMediator mediator) {
		super(mediator);
	}
	
	public void buyIBMcomputer(int number){
		super.mediator.execute("purchase.buy", number);
	}
	
	public void refuseBuyIBM(){
		System.out.println("Stop buying IBM computer for now.");
	}
   
}
