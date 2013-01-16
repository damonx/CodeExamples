package javaoopexample.closure;

public class TestClosure {

	public static void main(String[] args) {
       Sub sub = new Sub();
       Adjustable ad = sub.getCallBackReference();
       ad.adjust(15);
       sub.adjust(100);
       System.out.println(sub);
	}

}
