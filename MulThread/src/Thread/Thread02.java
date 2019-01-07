package Thread;


/**
 * 1. 自定义一个类实现java.lang包下的Runnable接口
 * 2. 重写run方法
 * 3. 将要在线程中执行的代码编写在run方法中
 * 4. 创建上面自定义的类的对象
 * 5. 创建Thread对象并将上面自定义的类对象作为参数传递给Thread的构造方法
 * 6. 调用start方法启动线程
 * @author zhaomimi
 * 
 */
class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("1024");
		}
		
	}
	
}
public class Thread02 {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread th = new Thread(mr);
		th.start();

	}

}
