package zenOfDesignPatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    Class cls = null;
    Object obj = null;
    
    public GamePlayIH(Object _obj){
    	this.obj = _obj;
    }
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("ATTENTION!!!! ------------->>>Invoking method: " + method.getName());
        Object result = method.invoke(this.obj, args);
        if("login".equalsIgnoreCase(method.getName())){
        	System.out.println("ATTENTION!!!! ------------->>> Someone is using my account.");
        }
		return result;
	}

}
