package Synchronize;

/**
 * 死锁
 * cmd下看死锁
 * 1. jps
 * 2. jstack -l id
 * @author zhaomimi
 *
 */
public class DeadThread {

	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread() {
			public void run() {
				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName() + "===obj1");
					synchronized (obj2) {
						System.out.println(Thread.currentThread().getName() + "===obj2");
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName() + "===obj2");
					synchronized (obj1) {
						System.out.println(Thread.currentThread().getName() + "===obj1");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}

}
