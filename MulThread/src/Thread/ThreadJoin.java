package Thread;

/**
 * 线程的加入
 * @author zhaomimi
 *
 */
public class ThreadJoin {

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
					if(i == 10) {
						try {
							//t1线程加入，直到t1执行完毕，才接着执行t2
							t1.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("1024");
				}
			}
		};
		t1.start();
		t2.start();
	}

}
