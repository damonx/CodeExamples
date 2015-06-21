package zenOfDesignPatterns.builder.after;

public class Client {

	public static void main(String[] args) {
        Director director = new Director();
        for (int i=0;i<100;i++){
        	director.getABenzModel().run();
        }
        
        for (int i=0; i<100;i++){
        	director.getBBenzModel().run();
        }
        
        
        for (int i=0;i<200;i++){
        	director.getCBmwModel().run();
        }
        
        for (int i=0;i<300;i++){
        	director.getDBmwModel().run();
        }
	}

}
