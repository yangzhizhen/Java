package communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReenTrantLock唤醒指定线程
 * @author zhaomimi
 *
 */
public class LockTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print2 p = new Print2();
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

class Print2 {
	//互斥锁
	private ReentrantLock rt = new ReentrantLock();
	//对象锁监视器
	private Condition c1 = rt.newCondition();
	private Condition c2 = rt.newCondition();
	private Condition c3 = rt.newCondition();
	
	private int flag = 1;
	//wait 释放对象锁
	//sleep 不释放对象锁
	//notify 不释放对象锁
	public void print1() {
		// TODO Auto-generated method stub
		//在要开始同步的地方加上锁
		rt.lock();
		while(flag != 1) {
			try {
				//让当前线程进入等待状态
				c1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("monkey");	
		flag = 2;
		//唤醒c2线程
		c2.signal();
		//在执行结束后释放锁
		rt.unlock();
		}
	}
	public void print2() {
		// TODO Auto-generated method stub
		rt.lock();
		while(flag != 2) {
			try {
				c2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("1024");	
		flag = 3;
		//唤醒c3线程
		c3.signal();
		rt.unlock();
	}
	public void print3() {
		// TODO Auto-generated method stub
		rt.lock();
		while(flag != 3) {
			try {
				c3.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("8888");	
		flag = 1;
		//唤醒c1线程
		c1.signal();
		rt.unlock();
	}
}