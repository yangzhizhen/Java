package Synchronize;

/**
 * 任务
 * @author zhaomimi
 *
 */
public class Task {
	//多个线程共享堆内存，某个时间段内，多个线程可以同时运行changeNum方法修改num的值，这样会导致线程安全问题
	private int num = 0;
	//同步和异步,synchronized锁住的是同一个对象的方法
	public synchronized void changeNum(boolean flag) {
		if(flag == true) {
			num = 88;
			System.out.println(Thread.currentThread().getName() + "==== begin");
			System.out.println(Thread.currentThread().getName() + "====" + num);
			System.out.println(Thread.currentThread().getName() + "==== end");
		} else {
			num = 66;
			System.out.println(Thread.currentThread().getName() + "==== begin");
			System.out.println(Thread.currentThread().getName() + "====" + num);
			System.out.println(Thread.currentThread().getName() + "==== end");
		}
	}

}
