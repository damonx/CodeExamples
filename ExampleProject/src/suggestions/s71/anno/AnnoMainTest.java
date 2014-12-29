package suggestions.s71.anno;

import suggestions.s71.anno.Desc.Color;

public class AnnoMainTest {

    public static void main(String[] args) {
        Bird bird = BirdNest.Sparrow.reproduce();
        Color color = bird.getColor();
        System.out.println("Color of sparrow is: " + color);
    }

}
