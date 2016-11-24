import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 自定义的网路类加载器
 * @author Administrator
 *
 */
public class NetWorkClassLoader extends ClassLoader {
	private String rootDir;

	public NetWorkClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData=getClassData(name);
		if(classData==null){
			throw new ClassNotFoundException(name+"这个类木有找到！！！");
		}else{
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
	private byte[] getClassData(String className) {
		byte[] classByte = null;
		try {
			String url = ClassNameToPath(className);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if (conn.getResponseCode() == conn.HTTP_OK) {// 如果连接成功
				InputStream is = conn.getInputStream();
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = is.read(b)) != -1) {
					baos.write(b, 0, len);
				}

				classByte = baos.toByteArray();
				is.close();
				baos.close();
				conn.disconnect();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classByte;
	}

	private String ClassNameToPath(String className) {
		return rootDir + "?classname=" + className;
	}
}
