package suggestions.s71.anno;

import suggestions.s71.anno.Desc.Color;


public class Sparrow extends Bird {
   private Color color;
   public Sparrow(){
       color = Color.Grayish;
   }
   
   public Sparrow(Color _color){
       color = _color;
   }
   
   @Override
   public Color getColor(){
       return color;
   }
}
