import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test_FileSystemClassLoader {

	public static void main(String[] args) {
		String rootDir="C:\\Users\\luowang\\workspace\\test\\bin";
		FileSystemClassLoader fscl=new FileSystemClassLoader(rootDir);
		String className="test.Test";
		try {
			Class<?> loadClass = fscl.loadClass(className);
			Method method = loadClass.getMethod("test",String.class);
			Object obj = loadClass.newInstance();
			method.invoke(obj,"玛德，强势的不行啊！！！");
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
