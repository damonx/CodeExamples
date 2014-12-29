package suggestions.s71.authentication;

public class MainTest {

    public static void main(String[] args) {
         Foo b = new Foo();
         Access access = b.getClass().getAnnotation(Access.class);
         if (access == null || !access.level().identify()){
             System.out.println(Identifier.REFUSE_WORD);
         }
    }

}
