package sample;
/**
 * 测试相同的类由两个不同的类加载器加载，在虚拟机中是不同的两个类
 * @author Administrator
 *
 */
public class Sample {
	public void setSample(String instance){
		System.out.println(instance);
	}
}
