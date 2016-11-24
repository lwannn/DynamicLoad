import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test_classloader {
	public static void main(String[] args) {
		try {
			// 自己手动用系统类加载器加载类
			// Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("sample.Sample");
			Class<?> loadClass = Class.forName("sample.Sample");
			Method method = loadClass.getMethod("setSample", String.class);
			Object obj = loadClass.newInstance();
			method.invoke(obj, "我真是服了你！！！");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
