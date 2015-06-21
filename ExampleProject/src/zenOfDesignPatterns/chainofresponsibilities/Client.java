package zenOfDesignPatterns.chainofresponsibilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

	public static void main(String[] args) {
        Random rand = new Random();
        List<IWomen> arrayList = new ArrayList<>();
        for(int i=0; i<5; i++){
        	int requestLevel = 0;
        	while ((requestLevel=rand.nextInt(4))==0){}
        	arrayList.add(new Women(requestLevel,"I'd like to hang out"));
        }
        
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        
        father.setNext(husband);
        husband.setNext(son);
        
        for (IWomen women : arrayList){
            father.HandleMessage(women);
        }    
	}

}
