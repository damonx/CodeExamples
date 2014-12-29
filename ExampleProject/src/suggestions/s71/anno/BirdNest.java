package suggestions.s71.anno;

public enum BirdNest {
  Sparrow;
  public Bird reproduce(){
      Desc bd = Sparrow.class.getAnnotation(Desc.class);
      return bd==null?new Sparrow():new Sparrow(bd.c());
  }
}
