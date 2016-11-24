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
			//尝试用接口来实现（貌似不行啊） 解决办法：接口的包路径要和服务器上的一致，不然会报错
			Versioned obj=(Versioned) clz.newInstance();
			int versioned = obj.getVersioned();
			
//			//用反射的方法调用
//			Object obj = clz.newInstance();
//			Method method = clz.getMethod("getVersioned");
//			int versioned = (int) method.invoke(obj);
			
			System.out.println("从网络获取的版本号为："+versioned);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
