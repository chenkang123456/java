import java.net.*;

/*
 * ������
 */




public class CS_Server 
{
    private static ServerSocket ss;

	public static void main(String[] args) throws Exception
    {
        ss = new ServerSocket(38380);
        System.out.println("���������ڵȴ��ͻ��˵���������----");
        //��һ��whileѭ������ͬʱ��Ӧ����ͻ��˵�����
        while(true){
             Socket sk= ss.accept();//������������Ӧ�˿ڵ�����
             ServerThread  st = new ServerThread(sk);//����һ���̣߳����̴߳���һ���׽���
             st.start();
        }
    }
}
