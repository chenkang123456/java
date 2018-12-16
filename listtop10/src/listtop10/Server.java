package listtop10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		OutputStream os = null;
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {

			serverSocket = new ServerSocket(6000);

			System.out.println("�������Ѿ�����!");
			socket = serverSocket.accept();

			// �ӿͻ��˶�ȡ���ݣ���Ҫ��ת��Ϊ�ַ���
			is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = str = br.readLine();
			//System.out.println("���Ƿ��������ͻ����������ϢΪ��" + str);
			System.out.println("���а�");
			socket.shutdownInput();

			// �Կͻ���������˺�������Ϣ���д���
			String[] str2 = str.split("&");
			HashMap<String, String> hm = new HashMap<>();
			for (String str1 : str2) {
				String[] str3 = str1.split(":");
				hm.put(str3[0], str3[1]);
			}

			String reply = "ѡ��ʧ��";
			if ("2".equals(hm.get("change"))
					&& "2".equals(hm.get("pwchange"))) {
				reply = "���а�";	
				System.out.println("����\t����\t����");
			}			
			// ��ͻ��˷�����Ϣ
			os = socket.getOutputStream();
			os.write(reply.getBytes());
			socket.shutdownOutput();            
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	}


