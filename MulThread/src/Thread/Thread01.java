package Thread;

/**
 * 1. 自定义一个类，继承java.lang包下的Thread类
 * 2. 重写run方法
 * 3. 将要在线程中执行的代码放到run方法中
 * 4. 创建上面自定义类的对象
 * 5. 调用start方法启动线程
 * @author zhaomimi
 *
 */

class MyThread extends Thread{
    @Override
    public void run() {
    	for(int i = 0; i < 1000; i++) {
    		System.out.println("monkey");
    	}
    }
}
public class Thread01 {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
	}
}
