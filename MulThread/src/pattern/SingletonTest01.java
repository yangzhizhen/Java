package pattern;

/**
 * 单例模式：保证软件在运行时，某个类在内存中只有一个对象
 * @author zhaomimi
 *
 */
public class SingletonTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}

}
//懒汉式，单例的延迟加载模式
class Singleton {
	//1. 构造方法私有化
	private Singleton() {
		
	}
	//2. 创建当前类的引用，使用volatile修饰
	private volatile static Singleton s = null;
	//3. 判断s是否为null，如果是空则创建一个Singleton对象，否则直接返回s
	//对外提供公共的同步的访问方法，将对象暴露给外部
	public synchronized static Singleton getInstance() {
		if(null == s) {
			s = new Singleton();
		}
		return s;
	}
}

//饿汉式
//class Singleton {
//	//1. 将构造方法设置为私有
//	private Singleton() {
//		
//	}
//	//2. 创建当前类的私有、静态对象
//	private static Singleton s = new Singleton();
//	//3. 创建公共方法，将对象暴露给外部
//	public static Singleton getInstance() {
//		return s;
//	}
//}
