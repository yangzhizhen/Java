package exercise;
/**
 * 练习：使用多线程程序模拟电影票售卖过程，一共有100张电影票，3个公司对外售卖
 * 分析：将100张电影票作为成员变量，开启三个线程开始执行，每当线程执行一次，票的总数减1
 * @author zhaomimi
 *
 */
public class Ticket implements Runnable{
	//100张电影票
	private int count = 100;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized (this) {
				if(count <= 0) {
					break;
				} else {
					//将电影票总数做自检运算
					count--;
					System.out.println(Thread.currentThread().getName() + "卖出一张，剩余" + count + "张");
				}
			}
		}
	}
	
	
	
}
