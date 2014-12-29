package suggestions.proxy.temp;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class AbsPopulator {
  public final void dataInitiating() throws Exception{
      Method[] methods = getClass().getMethods();
      for (Method m : methods){
          if (isInitDataMethod(m)){
              m.invoke(this);
          }
      }
  }
  
  private boolean isInitDataMethod(Method m){
      return m.getName().startsWith("init")&&
              Modifier.isPublic(m.getModifiers())&&
              m.getReturnType().equals(Void.TYPE)&&
              !m.isVarArgs()&&
              !Modifier.isAbstract(m.getModifiers());
  }
}
