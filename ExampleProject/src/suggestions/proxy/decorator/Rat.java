package suggestions.proxy.decorator;

public class Rat implements Animal {

    @Override
    public void doStuff() {
         System.out.println("Jerry will play with Tom ---" + getClass());
    }

}
