package Synchronize;

/**
 * 	将一个耗时较长的任务放到两个线程中，计算这两个线程执行结束后所耗费的时间
 * @author zhaomimi
 *
 */
public class SynchronizedTest02 {
	public static long begin1;
	public static long end1;
	public static long begin2;
	public static long end2;

	public static void main(String[] args) {
		
		LongTask longTask = new LongTask();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				begin1 = System.currentTimeMillis();
				//执行耗时较长任务方法
				longTask.changeNum(true);
				end1 = System.currentTimeMillis();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				begin2 = System.currentTimeMillis();
				//执行耗时较长任务方法
				longTask.changeNum(false);
				end2 = System.currentTimeMillis();
			}
		};
		
		t1.start();
		t2.start();
		
		//先让主线程睡眠，保证t1、t2线程执行完毕之后再计算时间
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long begin = 0;
		long end = 0;
		
		//将先执行的线程时间和最后执行线程的时间获取到
		if(begin1 > begin2) {
			begin = begin2;
		} else {
			begin = begin1;
		}
		
		if(end1 > end2) {
			end = end1;
		} else {
			end = end2;
		}
		System.out.println("两个线程共耗时：" + (end-begin)/1000 + "秒");
	}

}
