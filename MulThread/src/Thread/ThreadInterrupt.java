package Thread;

/**
 * 中断（唤醒）正在睡眠的线程
 * @author zhaomimi
 *
 */
public class ThreadInterrupt {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				try {
					Thread.sleep(100000000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i = 0; i < 10; i++) {
					System.out.println("sleep");
				}
			}
		};
		t1.start();
		//唤醒睡眠中的线程
		t1.interrupt();

	}

}
