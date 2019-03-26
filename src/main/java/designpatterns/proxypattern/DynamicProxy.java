package designpatterns.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {
	public static <T> T newProxyInstance(
					ClassLoader loader,
					Class<?>[] interfaces,
					InvocationHandler handler) {
		if (true) {
			(new PreNotice()).exec();
		}
		return (T) Proxy.newProxyInstance(loader, interfaces, handler);
	}
}
