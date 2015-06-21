package zenOfDesignPatterns.mediator;

public class Client {

	public static void main(String[] args) {
       AbstractMediator mediator = new Mediator();
       System.out.println("-----------------Buy computer------------");
       Purchase purchase = new Purchase(mediator);
       purchase.buyIBMcomputer(100);
       
       System.out.println("\n----------------Sell computers-------------");
       Sale sale = new Sale(mediator);
       sale.sellIBMComputer(1);
       
       System.out.println("\n ---------------Clearance-------------------");
       Stock stock = new Stock(mediator);
       stock.clearStock();
	}


}
