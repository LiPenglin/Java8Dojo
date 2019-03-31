package designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClubHandler implements InvocationHandler {
	private Object target = null;


	public ClubHandler(Object _obj) {
		target = _obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("waiter come."); // aspect1
		Object res = method.invoke(target, args);
		System.out.println("after go."); // aspect2
		return res;
	}
}
