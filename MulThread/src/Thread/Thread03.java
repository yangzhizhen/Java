package Thread;

import java.lang.reflect.Executable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1. 自定义一个类实现java.util.concurrent包下的Callable接口
 * 2. 重写call方法
 * 3. 将要在线程池中执行的代码编写在call方法中
 * 4. 创建ExecutorService线程池
 * 5. 将自定义类的对象放入到线程池中
 * 6. 获取线程的返回结果
 * 7. 关闭线程池，不再接收新的线程，未执行完的线程不会关闭
 * 
 * @author zhaomimi
 *
 */
class MyCallable implements Callable<Integer>{
	//阶乘
	private int count;
	public MyCallable(int count) {
		this.count = count;
	}
	
	
	@Override
	public Integer call() throws Exception {
		int sum = 1;
		if(count != 0) {
			for(int i = 1; i <= count; i++) {
				sum *= i;
			}
		} else {
			sum = 0;
		}
		
		return sum;
	}
	
}

public class Thread03 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//创建一个线程池，里面的线程会根据任务数量进行添加
		ExecutorService es = Executors.newCachedThreadPool();
		
		Future<Integer> fu1 = es.submit(new MyCallable(5));
		Future<Integer> fu2 = es.submit(new MyCallable(3));
//		System.out.println(fu1.get());
//		System.out.println(fu2.get());
		//判断线程中的任务是否执行完毕
		if(fu1.isDone()) {
			System.out.println(fu1.get());
		} else {
			System.out.println("fu1线程中的人物还未执行完毕");
		}
		if(fu2.isDone()) {
			System.out.println(fu2.get());
		} else {
			System.out.println("fu2线程中的人物还未执行完毕");
		}
		es.shutdown();
	}

}
