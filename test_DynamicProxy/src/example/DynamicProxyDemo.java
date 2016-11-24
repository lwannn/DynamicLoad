package example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import Interface.Subject;

/**
 * java实现动态代理类的例子
 * @author Administrator
 *
 */
public class DynamicProxyDemo {

	public static void main(String[] args) {
		realSubject realsubject=new realSubject();
		ProxyHandler handler=new ProxyHandler(realsubject);
		Subject newProxyInstance = (Subject) Proxy.newProxyInstance(realSubject.class.getClassLoader(), realSubject.class.getInterfaces(), handler);
		newProxyInstance.request();
	}
}
