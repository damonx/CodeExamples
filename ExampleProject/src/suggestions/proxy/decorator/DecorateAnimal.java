package suggestions.proxy.decorator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class DecorateAnimal implements Animal {

    private Animal animal;
    private Class<? extends Feature> clz;
    
    public DecorateAnimal(Animal _animal, Class<? extends Feature> _clz){
        animal = _animal;
        clz = _clz;
    }
    
    @Override
    public void doStuff() {
        InvocationHandler handler = new InvocationHandler() {
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                Object obj = null;
                if (Modifier.isPublic(method.getModifiers())){
                    obj = method.invoke(clz.newInstance(), args);
                }
                
                animal.doStuff();
                return obj;
            }
        };
        
        ClassLoader cl = getClass().getClassLoader();
        Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
        proxy.load();
        
    }

}
