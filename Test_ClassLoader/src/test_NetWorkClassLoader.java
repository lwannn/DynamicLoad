import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import test.Versioned;

public class test_NetWorkClassLoader {

	public static void main(String[] args) {
		String rootDir="http://localhost:8080/test/get";
		NetWorkClassLoader classLoader=new NetWorkClassLoader(rootDir);
		String className="test.test";
		try {
			Class<?> clz = classLoader.loadClass(className);
			//�����ýӿ���ʵ�֣�ò�Ʋ��а��� ����취���ӿڵİ�·��Ҫ�ͷ������ϵ�һ�£���Ȼ�ᱨ��
			Versioned obj=(Versioned) clz.newInstance();
			int versioned = obj.getVersioned();
			
//			//�÷���ķ�������
//			Object obj = clz.newInstance();
//			Method method = clz.getMethod("getVersioned");
//			int versioned = (int) method.invoke(obj);
			
			System.out.println("�������ȡ�İ汾��Ϊ��"+versioned);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
