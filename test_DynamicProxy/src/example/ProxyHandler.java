package example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import Interface.Subject;

/**
 * ���ô�������
 * @author Administrator
 *
 */
public class ProxyHandler implements InvocationHandler{
    private Subject subject;
    
	public ProxyHandler(Subject subject) {
		super();
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("=====����ǰ=====");
		Object result = method.invoke(subject, args);
		System.out.println("=====�����=====");
		return result;
	}
	
}
