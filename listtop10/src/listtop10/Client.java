package listtop10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 6000);

			os = socket.getOutputStream();
			is = socket.getInputStream();

			// �������������Ϣ����Ҫ��ת��Ϊ�ֽ���
			Scanner can = new Scanner(System.in);
			System.out.println("����ѡ��");
			String change = can.next();
			System.out.println("ȷ������ѡ��");
			String pwchange = can.next();
			String str = "change:" + change + "&pwchange:" + pwchange;
			byte[] b = str.getBytes();
			os.write(b);
			socket.shutdownOutput();

			// �ӷ�������ȡ��Ϣ����Ҫ�Ȱ��ֽ���ת��Ϊ���׶�ȡ���ַ���
			BufferedReader bis = new BufferedReader(new InputStreamReader(is));
			String str2 = bis.readLine();
			System.out.println("�ͻ����������������ӦΪ==>" + str2);
			
			socket.shutdownInput();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
