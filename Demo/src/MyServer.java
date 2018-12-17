
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;

/*24分游戏
 * 服务器端，在9999端口上监听
 * 可以通过控制台，输入给客户端的信息
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

			System.out.println("服务器启动请选择菜单!");
			System.out.println("\t1.玩游戏\n\t2.排行榜");
			socket = serverSocket.accept();

			// 从客户端读取数据，需要先转换为字符流
			is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = str = br.readLine();
			System.out.println("我是服务器，客户端输入的消息为：" + str);
			socket.shutdownInput();

			// 对客户端输入的账号密码信息进行处理
			String[] str2 = str.split("&");
			HashMap<String, String> hm = new HashMap<>();
			for (String str1 : str2) {
				String[] str3 = str1.split(":");
				hm.put(str3[0], str3[1]);
			}

			String reply = "选择失败";
			if ("1".equals(hm.get("change"))
					&& "1".equals(hm.get("pwchange"))) {
				reply = "游戏开始！";	
				System.out.println("开始游戏");
				int a=(int)(Math.random()*9+1);
				int b=(int)(Math.random()*9+1);
				int c=(int)(Math.random()*9+1);
				int d=(int)(Math.random()*9+1);	
				System.out.println("n1\tn2\tn3\tn4");
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
				System.out.println("请输入：");
				socket = serverSocket.accept();
				is = socket.getInputStream();				
				
			}			
			// 向客户端发送消息
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