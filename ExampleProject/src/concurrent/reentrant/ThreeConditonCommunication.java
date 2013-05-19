package concurrent.reentrant;

public class ThreeConditonCommunication {
    public static void main(String[] args) {
         final MyThread m = new MyThread();
         
         new Thread(new Runnable() {
              @Override
              public void run() {
                   for (int i = 0; i < 10; i++) {
                        m.sub1();
                   }
              }
         }).start();

         new Thread(new Runnable() {
              @Override
              public void run() {
                   for (int i = 0; i < 10; i++) {
                        m.sub2();
                   }
              }
         }).start();
         
         for (int i = 0; i < 10; i++) {
              m.main();
         }
    }
}
