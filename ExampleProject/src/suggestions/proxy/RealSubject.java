package suggestions.proxy;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real request from " + getClass());   
    }

}
