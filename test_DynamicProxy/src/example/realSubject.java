package example;

import Interface.Subject;
/**
 * 委托类（被代理的类）
 * @author Administrator
 *
 */
public class realSubject implements Subject {

	@Override
	public void request() {
		System.out.println("我使用双截棍，哼哼哈嘿！");
	}

}
