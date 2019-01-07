package Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Timer t = new Timer();
		t.schedule(new MyTimerTask(), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").parse("2019-01-07  12:02:30 000"), 5000);
	}


}
/**
 * 继承TimerTask类，将要执行的定时任务编写在run方法中
 * @author zhaomimi
 *
 */
class MyTimerTask extends TimerTask {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("www.baidu.com");
	}
	
}
