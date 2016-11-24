import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �Զ�����ļ�ϵͳ������
 * 
 * @author Administrator
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;// ��Ҫ����.class�ļ��ĸ�Ŀ¼��һ����binĿ¼��

	public FileSystemClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException(name + "�����ľ���ҵ�������");
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getClassData(String className) {// ��ȡ.class�ļ��Ķ������ļ�
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

	private String ClassNameToPath(String className) {// ��ȡ.class�ļ��ľ���·��
		String classPath = "";
		if (className.contains(".")) {// ���className������Ļ�
			if (className.indexOf(".") == className.lastIndexOf(".")) {//����ֻ����һ����
				classPath = rootDir + File.separator + className.replace(".", File.separator) + ".class";
			} else {//���ж����
				classPath = rootDir + File.separator + className.replaceAll(".", File.separator) + ".class";
			}
		} else {
			classPath = rootDir + File.separator + className + ".class";
		}
		return classPath;
	}
}
