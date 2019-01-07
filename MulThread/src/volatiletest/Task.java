package volatiletest;
/**
 * volatile的作用是可以保持共享变量的可见性，即一个线程修改一个共享变量后，另一个线程能够读取到这个修改后的值
 * volatile是非原子性的
 * synchronized是原子性的
 * 如果一段程序是具有原子性的，那么这段程序就不会出现线程安全问题
 * 原子性：即一个操作或者多个操作要么全部执行并且执行的过程不会被任何因素中断，要么就不执行
 * @author zhaomimi
 *
 */
public class Task implements Runnable{
	//volatile只能声明变量，不能声明方法
	private volatile boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println("while循环");
		}
		System.out.println("循环结束");
		
	}
	
}
