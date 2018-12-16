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

			System.out.println("服务器已经启动!");
			socket = serverSocket.accept();

			// 从客户端读取数据，需要先转换为字符流
			is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = str = br.readLine();
			//System.out.println("我是服务器，客户端输入的消息为：" + str);
			System.out.println("排行榜");
			socket.shutdownInput();

			// 对客户端输入的账号密码信息进行处理
			String[] str2 = str.split("&");
			HashMap<String, String> hm = new HashMap<>();
			for (String str1 : str2) {
				String[] str3 = str1.split(":");
				hm.put(str3[0], str3[1]);
			}

			String reply = "选择失败";
			if ("2".equals(hm.get("change"))
					&& "2".equals(hm.get("pwchange"))) {
				reply = "排行榜！";	
				System.out.println("名次\t分数\t名字");
			}			
			// 向客户端发送消息
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


