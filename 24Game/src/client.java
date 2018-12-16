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

			// 向服务器发送消息，需要先转换为字节流
			Scanner can = new Scanner(System.in);
			System.out.println("输入账号：");
			String name = can.next();
			System.out.println("输入密码：");
			String password = can.next();
			String str = "name:" + name + "&password:" + password;
			byte[] b = str.getBytes();
			os.write(b);
			socket.shutdownOutput();

			// 从服务器读取信息，需要先把字节流转换为容易读取的字符流
			BufferedReader bis = new BufferedReader(new InputStreamReader(is));
			String str2 = bis.readLine();
			System.out.println("客户端输出：服务器回应为==>" + str2);
			
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
