import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义的文件系统加载类
 * 
 * @author Administrator
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;// 是要加载.class文件的父目录（一般是bin目录）

	public FileSystemClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException(name + "这个类木有找到！！！");
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getClassData(String className) {// 获取.class文件的二进制文件
		byte[] classByte = null;
		String path = ClassNameToPath(className);
		File file = new File(path);
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(file);
			baos = new ByteArrayOutputStream();
			byte[] bufferByte = new byte[4096];
			int len = 0;
			while ((len = is.read(bufferByte)) != -1) {
				baos.write(bufferByte, 0, len);
			}
			classByte = baos.toByteArray();

			baos.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classByte;
	}

	private String ClassNameToPath(String className) {// 获取.class文件的绝对路径
		String classPath = "";
		if (className.contains(".")) {// 如果className包含点的话
			if (className.indexOf(".") == className.lastIndexOf(".")) {//并且只含有一个点
				classPath = rootDir + File.separator + className.replace(".", File.separator) + ".class";
			} else {//含有多个点
				classPath = rootDir + File.separator + className.replaceAll(".", File.separator) + ".class";
			}
		} else {
			classPath = rootDir + File.separator + className + ".class";
		}
		return classPath;
	}
}
