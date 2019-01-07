package Thread;

/**
 * Thread类中的Sleep方法，让当前线程睡眠
 * @author zhaomimi
 *
 */
public class Sleep {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("monkey");
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("1024");
				}
			}
		}.start();
		
//		for(int i = 10; i > 0; i-- ) {
//			//让当前线程睡眠1000毫秒
//			Thread.sleep(1000);
//			System.out.println("倒计时：" + i);
//		}
	}

}
