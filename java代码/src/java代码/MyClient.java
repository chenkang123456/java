package java����;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/*
 * �ͻ���
 */
public class MyClient {
	

	
	
	
	    private static Scanner sn;

		public static void main(String[] args) 
	    {
	        try{
	        Socket sk =new Socket("127.0.0.1",38380);
	        System.out.println("�ͻ����Ѿ�����----");
	        PrintStream ps = new PrintStream(sk.getOutputStream());//���ͻ����׽��ֵ��������printStream��װ������������C�����е�fprintf����ת��
	        System.out.print("��������Ҫ���͵������������ݣ�");
	        
	        sn = new Scanner(System.in);
	        String str = sn.nextLine();
	        
	        ps.println(str);//�ѿ���̨������������뱻printstream���װ�����������  
	        ps.close();//�ر��������װ
	        sk.close();//�ر�socket�׽��֣��Ѿ��������ݣ����ܹر�
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	}

