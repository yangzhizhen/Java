package communication;

/**
 * 两个线程之间的通信
 * 让两个线程交替在控制台输出一行文字
 * @author zhaomimi
 *
 */
public class NotifyTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print p = new Print();
		Thread t1  = new Thread() {
			public void run() {
				while(true) {
					p.print1();	
				}
			}
		};
		Thread t2  = new Thread() {
			public void run() {
				while(true) {
					p.print2();
				}
			}
		};
		t1.start();
		t2.start();
	}

}

class Print {
	private int flag = 1;
	
	public void print1() {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(flag != 1) {
				try {
					//让当前线程进入等待状态
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("monkey");	
			flag = 2;
			//随机地唤醒单个等待的线程
			this.notify();
		}
	}
	public void print2() {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(flag != 2) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("1024");	
			flag = 1;
			this.notify();
		}
	}
}