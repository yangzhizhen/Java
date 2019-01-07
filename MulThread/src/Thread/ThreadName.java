package Thread;

/**
 * 设置和获取线程名字
 * @author zhaomimi
 *
 */
public class ThreadName {

	public static void main(String[] args) {
//		method01();
//		method02();
		method03();
	}
	/**
	 * 方式三
	 */
	private static void method03() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("我是" + this.getName());
			};
		};
		
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("我是" + this.getName());
			};
		};
		t1.setName("马化腾");
		t2.setName("马云");
		t1.start();
		t2.start();
	}
	/**
	 * 方式二
	 */
	private static void method02() {
		new Thread() {
			@Override
			public void run() {
				this.setName("马化腾");
				System.out.println("我是" + this.getName());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				this.setName("马云");
				System.out.println("我是" + this.getName());
			}
		}.start();
	}
	/**
	 * 方式一
	 */
	private  static void method01() {
		new Thread("马化腾") {
			@Override
			public void run() {
				System.out.println("我是" + this.getName());
			}
		}.start();
		
		new Thread("马云") {
			@Override
			public void run() {
				System.out.println("我是" + this.getName());
			}
		}.start();
	}

}
