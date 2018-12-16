import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 6013);

			os = socket.getOutputStream();
			is = socket.getInputStream();

			// �������������Ϣ����Ҫ��ת��Ϊ�ֽ���
			Scanner can = new Scanner(System.in);
			System.out.println("�����˺ţ�");
			String name = can.next();
			System.out.println("�������룺");
			String password = can.next();
			String str = "name:" + name + "&password:" + password;
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
