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
	static boolean flag = true;//�ñ�����ʶ�Ƿ�ʱ
	static int life = 3;//��ʼ������ֵ
	static int score=0;//��ʼ������

	/**
	 *��ʼ��Ϸ�ķ������÷���ͨ����ǰ����ֵ�ж��Ƿ���� 
	 */
	public void start() throws IOException {
		Calendar date = Calendar.getInstance();//ʵ����Calendar����
		while(life>0) {//������ֵ����0�Ż����
			flag=true;//��ʼ���������
			date.setTime(new Date());
			date.add(Calendar.SECOND, 20);//�����޶�ʱ��
			Timer timer = new Timer();
			//���ﵽ�޶�ʱ�佫��ִ��run()����,����ȫ�ֱ���flag��Ϊfalse
			timer.schedule(new RemindTask(), date.getTime());
			int answer = answer();
			switch(answer) {
			case -1:
				System.out.println("���ʽ���󣡣�    ��ǰ����ֵΪ"+life+" ����Ϊ��"+score);
				break;
			case -2:
				System.out.println("���볬ʱ����    ��ǰ����ֵΪ"+life+" ����Ϊ��"+score);
				break;
			case -3:
				System.out.println("������󣡣�    ��ǰ����ֵΪ"+life+" ����Ϊ��"+score);
				break;
			case 1:	
				System.out.println("��ȷ,�õ�1�ֽ�������    ��ǰ����ֵΪ"+life+" ����Ϊ��"+score);
				break;
			}
			System.out.println("----------");
		}
		System.out.println("��Ϸ������������Ϊ: "+score);//ѭ������Ҳ��������ֵΪ0,��ӡ��Ϸ����
		saveScore(score);//����ҵ�ǰ���������ļ�
		return;
	}
/**
 * 
 * Title: getData</p>  
 * Description:�������������   
 * @return
 */
	private float[] getData() {
		float[] data = new float[4];
		Random r = new Random();//��������ĸ����ݴ���������
		data[0] = r.nextInt(12) + 1;
		data[1] = r.nextInt(12) + 1;
		data[2] = r.nextInt(12) + 1;
		data[3] = r.nextInt(12) + 1;
		System.out.print("�ĸ�����Ϊ��");
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
		System.out.println("�뿪ʼ����ʱ��20��");
		return data;
	}

	/**
	 * 
	 * Title: answer</p>  
	 * Description:�����û����뷵��false��true
	 * 1.���벻������ֵ������FALSE
	 * 2.���볬ʱ������false
	 * 3.������ʽ��ֵ��Ϊ24������false
	 * ���򣬷���true   
	 * @return -1��������ı��ʽ��ϵͳ���������ֲ��Ǻ�
	 * @return -2�����û���������ʱ
	 * @return -3����������
	 * @return 1�����û�������ȷ
	 */
	public int answer() {
		Scanner sc = new Scanner(System.in);
		float[] data = getData();//��ȡ����������
		//��ȡscript���棬����eval()�������жϱ��ʽ�Ƿ���ȷ
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
		String exper = sc.next();
		try {
			String res = String.valueOf(scriptEngine.eval(exper));
			for (int i = 0; i < data.length; i++)
				if (!exper.contains(data[i] + "")) {//����ı��ʽ����������ֵ
					life--;
					return -1;
				}
			if(!flag) {//�жϳ�ʱ
				life--;
				return -2;
			}
			if (res.equals("24")) {//�ش����_����û�г�ʱ
				score++;//������һ
				return 1;
			}
			life--;
		} catch (ScriptException e) {
			System.out.println("���ʽ���벻�Ϸ�");
		}
		return -3;

	}
	/**
	 * Title: saveScore</p>  
	 * Description:   �÷�����ʾ����ҵ�ǰ��������TopList.txt�ļ�
	 * @param score ��Ҫ����ķ���
	 * @throws IOException
	 */
	public static void saveScore(int score) throws IOException {
		FileOutputStream fos = new FileOutputStream("e:/TopList.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write((score+"").getBytes());//�ѷ���д���ļ�
		bos.close();
		
	}
	public static void main(String[] args) throws IOException {
		saveScore(1);
	}
}
/**
 * 
* Title: RemindTask
* Description:��TimerTask������дrun()����ʵ����ָ���Ķ�ʱʱ��ִ��run����������
* @author jianglei  
 */
class RemindTask extends TimerTask {

	@Override
	public void run() {
		AutoGame.flag = false;//����ʱ���ȫ�ֱ���flag��Ϊfalse
	}

}
