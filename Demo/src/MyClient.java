
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MyClient {
	/*
	 * 
	 * @param  args
	 */	
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 6001);

			os = socket.getOutputStream();
			is = socket.getInputStream();

			// 向服务器发送消息，需要先转换为字节流
			Scanner can = new Scanner(System.in);
			System.out.println("输入选择：");
			String change = can.next();
			System.out.println("确认选择：");
			String pwchange = can.next();
			String str = "change:" + change + "&pwchange:" + pwchange;
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
		 }catch(IOException e){				
			e.printStackTrace();
			// TODO Auto-generated catch block
		} 
		 
		 
		} 
}
	 
}	 


	   

	  
	       
	   

	