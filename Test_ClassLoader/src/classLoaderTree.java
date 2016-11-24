/**
 * 演示类加载器的tree结构
 * @author Administrator
 *
 */
public class classLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader=classLoaderTree.class.getClassLoader();//获取类加载器
		while(loader!=null){//这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，getParent()方法返回 null
			System.out.println(loader.toString());
			loader=loader.getParent();
		}
	}

	/**
	 * 运行结果
	 * sun.misc.Launcher$AppClassLoader@73d16e93 系统类加载器是该类的实例
     * sun.misc.Launcher$ExtClassLoader@15db9742 扩展类加载器是该类的实例
	 */
}
