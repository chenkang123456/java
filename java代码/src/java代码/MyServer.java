package java����;
import java.net.*;

/*
 * ������
 */




public class MyServer 
{
    private static ServerSocket ss;

	public static void main(String[] args) throws Exception
    {
        ss = new ServerSocket(38381);
        System.out.println("���������ڵȴ��ͻ��˵���������----");
        //��һ��whileѭ������ͬʱ��Ӧ����ͻ��˵�����
        while(true){
             Socket sk= ss.accept();//������������Ӧ�˿ڵ�����
             ServerThread  st = new ServerThread(sk);//����һ���̣߳����̴߳���һ���׽���
             st.start();
        }
    }
}

	
	
