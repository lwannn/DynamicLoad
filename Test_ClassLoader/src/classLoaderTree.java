/**
 * ��ʾ���������tree�ṹ
 * @author Administrator
 *
 */
public class classLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader=classLoaderTree.class.getClassLoader();//��ȡ�������
		while(loader!=null){//����������Щ JDK ��ʵ�ֶ��ڸ����������������������������getParent()�������� null
			System.out.println(loader.toString());
			loader=loader.getParent();
		}
	}

	/**
	 * ���н��
	 * sun.misc.Launcher$AppClassLoader@73d16e93 ϵͳ��������Ǹ����ʵ��
     * sun.misc.Launcher$ExtClassLoader@15db9742 ��չ��������Ǹ����ʵ��
	 */
}
