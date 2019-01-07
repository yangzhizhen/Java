package Thread;

/**
 * 线程礼让
 * @author zhaomimi
 *
 */
public class ThreadYield {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("领导");
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					if(i % 2 == 0) {
						//礼让
						Thread.yield();
					}
					System.out.println("员工");
				}
			}
		};
		t1.start();
		t2.start();

	}

}
