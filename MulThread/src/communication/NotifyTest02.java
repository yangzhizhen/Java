package communication;

/**
 * 三个或三个以上的线程通信
 * 让两个线程交替在控制台输出一行文字
 * @author zhaomimi
 *
 */
public class NotifyTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print1 p = new Print1();
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
		Thread t3  = new Thread() {
			public void run() {
				while(true) {
					p.print3();
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}

}

class Print1 {
	private int flag = 1;
	//wait 释放对象锁
	//sleep 不释放对象锁
	//notify 不释放对象锁
	public void print1() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(flag != 1) {
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
			this.notifyAll();
		}
	}
	public void print2() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(flag != 2) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("1024");	
			flag = 3;
			this.notifyAll(); 
		}
	}
	public void print3() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(flag != 3) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("8888");	
			flag = 1;
			this.notifyAll(); 
		}
	}
}