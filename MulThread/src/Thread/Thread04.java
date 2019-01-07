package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用匿名内部类创建线程
 * @author zhaomimi
 *
 */
public class Thread04 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Thread
		new Thread() { //1. 创建Thread类对象
			@Override
			public void run() { //2. 重写run方法
				for(int i = 0; i < 100; i++) { //3. 将要在线程中执行的代码编写在run方法中
					System.out.println("monkey");
				}
			}
		}.start(); //4.启动线程
		
		//Runnable
		new Thread(new Runnable() { //1. 创建Thread类对象 2. 创建runnable类型对象
			@Override
			public void run() { //3. 重写run方法 
				for(int i = 0; i < 100; i++) { //4. 将要在线程中执行的代码编写在run方法中
					System.out.println("1024");
				}
			}
		}) {
		}.start(); //5. 启动线程
		
		//Callable
		ExecutorService es = Executors.newCachedThreadPool(); //1. 创建线程池
		Future<Integer> result = es.submit(new Callable<Integer>() { //2. 创建Callable类型对象，重写call方法 3. 将Callable类型对象放入到线程中 4. 获取线程返回的Future对象
			@Override
			public Integer call() throws Exception { 
				return 88;
			}
		});
		System.out.println(result.get()); //5. 获取线程计算的返回结果
		es.shutdown(); //6. 关闭线程池
		
	}

}
