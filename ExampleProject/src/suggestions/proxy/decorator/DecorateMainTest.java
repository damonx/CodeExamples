package suggestions.proxy.decorator;

public class DecorateMainTest {
   public static void main(String[] args) {
      Animal Jerry = new Rat();
      Jerry = new DecorateAnimal(Jerry, FlyFeature.class);
      Jerry = new DecorateAnimal(Jerry, DigFeature.class);
      Jerry.doStuff();
   }
}
