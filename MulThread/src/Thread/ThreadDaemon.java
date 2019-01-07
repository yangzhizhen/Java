package Thread;

/**
 * 守护线程
 * 当非守护线程结束之后，守护线程也结束
 * 类似于Java的垃圾回收期
 * @author zhaomimi
 *
 */
public class ThreadDaemon {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("守护线程");
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("非守护线程");
				}
			}
		};
		//将t1设置为守护线程
		t1.setDaemon(true);
		t1.start();
		t2.start();
		
	}

}
