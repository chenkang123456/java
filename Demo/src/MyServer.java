
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;

/*24����Ϸ
 * �������ˣ���9999�˿��ϼ���
 * ����ͨ������̨��������ͻ��˵���Ϣ
 */
public class MyServer {
	/*
	 * 
	 * @param  args
	 */
	public static void main(String[] args) {
		
		InputStream is = null;
		OutputStream os = null;
		int sum = 0;
		int score=0;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {

			serverSocket = new ServerSocket(6005);

			System.out.println("������������ѡ��˵�!");
			System.out.println("\t1.����Ϸ\n\t2.���а�");
			socket = serverSocket.accept();

			// �ӿͻ��˶�ȡ���ݣ���Ҫ��ת��Ϊ�ַ���
			is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = str = br.readLine();
			System.out.println("���Ƿ��������ͻ����������ϢΪ��" + str);
			socket.shutdownInput();

			// �Կͻ���������˺�������Ϣ���д���
			String[] str2 = str.split("&");
			HashMap<String, String> hm = new HashMap<>();
			for (String str1 : str2) {
				String[] str3 = str1.split(":");
				hm.put(str3[0], str3[1]);
			}

			String reply = "ѡ��ʧ��";
			if ("1".equals(hm.get("change"))
					&& "1".equals(hm.get("pwchange"))) {
				reply = "��Ϸ��ʼ��";	
				System.out.println("��ʼ��Ϸ");
				int a=(int)(Math.random()*9+1);
				int b=(int)(Math.random()*9+1);
				int c=(int)(Math.random()*9+1);
				int d=(int)(Math.random()*9+1);	
				System.out.println("n1\tn2\tn3\tn4");
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
				System.out.println("�����룺");
				socket = serverSocket.accept();
				is = socket.getInputStream();				
				
			}			
			// ��ͻ��˷�����Ϣ
			os = socket.getOutputStream();
			os.write(reply.getBytes());
			socket.shutdownOutput();            
		} 
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
				socket.close();
				serverSocket.close();
	  }catch (IOException e) {
          e.printStackTrace();
      }
  }
  
}
	
}