package Thread;

/**
 * Thread类中的setPriority方法设置线程的优先级
 * 取值范围是整数1~10，优先级随着数字的增大而增强
 * @author zhaomimi
 *
 */
public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("monkey");
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("1024");
				}
			}
		};
//		t1.setPriority(2);
//		t2.setPriority(8);
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		
	}

}
