import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AutoGame {
	static boolean flag = true;//该变量标识是否超时
	static int life = 3;//初始化生命值
	static int score=0;//初始化分数

	/**
	 *开始游戏的方法，该方法通过当前生命值判断是否结束 
	 */
	public void start() throws IOException {
		Calendar date = Calendar.getInstance();//实例化Calendar对象
		while(life>0) {//当生命值大于0才会进行
			flag=true;//初始化分数标记
			date.setTime(new Date());
			date.add(Calendar.SECOND, 20);//设置限定时间
			Timer timer = new Timer();
			//当达到限定时间将会执行run()方法,即把全局变量flag变为false
			timer.schedule(new RemindTask(), date.getTime());
			int answer = answer();
			switch(answer) {
			case -1:
				System.out.println("表达式错误！！    当前生命值为"+life+" 分数为："+score);
				break;
			case -2:
				System.out.println("输入超时！！    当前生命值为"+life+" 分数为："+score);
				break;
			case -3:
				System.out.println("结果错误！！    当前生命值为"+life+" 分数为："+score);
				break;
			case 1:	
				System.out.println("正确,得到1分奖励！！    当前生命值为"+life+" 分数为："+score);
				break;
			}
			System.out.println("----------");
		}
		System.out.println("游戏结束……分数为: "+score);//循环结束也就是生命值为0,打印游戏结束
		saveScore(score);//将玩家当前分数存入文件
		return;
	}
/**
 * 
 * Title: getData</p>  
 * Description:给定任意的数据   
 * @return
 */
	private float[] getData() {
		float[] data = new float[4];
		Random r = new Random();//随机生成四个数据存入数组中
		data[0] = r.nextInt(12) + 1;
		data[1] = r.nextInt(12) + 1;
		data[2] = r.nextInt(12) + 1;
		data[3] = r.nextInt(12) + 1;
		System.out.print("四个数字为：");
		for (float f : data)
			switch ((int) f) {
			case 1:
				System.out.print("A" + " ");
				break;
			case 11:
				System.out.print("J" + " ");
				break;
			case 12:
				System.out.print("O" + " ");
				break;
			case 13:
				System.out.print("K" + " ");
				break;
			default:
				System.out.print((int) f + " ");
				break;
			}
		System.out.println("请开始作答，时间20秒");
		return data;
	}

	/**
	 * 
	 * Title: answer</p>  
	 * Description:根据用户输入返回false或true
	 * 1.输入不含给定值，返回FALSE
	 * 2.输入超时，返回false
	 * 3.输入表达式的值不为24，返回false
	 * 否则，返回true   
	 * @return -1代表输入的表达式与系统给出的数字不吻合
	 * @return -2代表用户计算结果超时
	 * @return -3代表结果错误
	 * @return 1代表用户计算正确
	 */
	public int answer() {
		Scanner sc = new Scanner(System.in);
		float[] data = getData();//获取给定的数据
		//获取script引擎，调用eval()方法来判断表达式是否正确
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
		String exper = sc.next();
		try {
			String res = String.valueOf(scriptEngine.eval(exper));
			for (int i = 0; i < data.length; i++)
				if (!exper.contains(data[i] + "")) {//输入的表达式不含给定的值
					life--;
					return -1;
				}
			if(!flag) {//判断超时
				life--;
				return -2;
			}
			if (res.equals("24")) {//回答正確并且没有超时
				score++;//分数加一
				return 1;
			}
			life--;
		} catch (ScriptException e) {
			System.out.println("表达式输入不合法");
		}
		return -3;

	}
	/**
	 * Title: saveScore</p>  
	 * Description:   该方法表示将玩家当前分数存入TopList.txt文件
	 * @param score 需要存入的分数
	 * @throws IOException
	 */
	public static void saveScore(int score) throws IOException {
		FileOutputStream fos = new FileOutputStream("e:/TopList.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write((score+"").getBytes());//把分数写入文件
		bos.close();
		
	}
	public static void main(String[] args) throws IOException {
		saveScore(1);
	}
}
/**
 * 
* Title: RemindTask
* Description:该TimerTask并且重写run()可以实现在指定的定时时间执行run方法的内容
* @author jianglei  
 */
class RemindTask extends TimerTask {

	@Override
	public void run() {
		AutoGame.flag = false;//当超时会把全局变量flag变为false
	}

}
