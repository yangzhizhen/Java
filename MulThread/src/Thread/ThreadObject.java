package Thread;

/**
 * 获取线程对象
 * @author zhaomimi
 *
 */
public class ThreadObject {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//获取当前线程的对象
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
		//主线程的名字
		System.out.println(Thread.currentThread().getName());
	}

}
