
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


import org.junit.Test;


//从客户端发送文件给服务端,服务端将文件保存在本地，并返回“发送成功”给客户端，并关闭相应连接

public class TestTCP3 {
	@Test
	public void client()throws Exception{
		//1.创建Socket的对象
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8989);
	    //2.从本地获取一个文件发送给服务端
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		byte[] b = new byte[1024] ;
		int len;
		while((len = fis.read(b))!=-1){
			os.write(b,0,len);
		}
		socket.shutdownOutput();
		//3.接受来自服务端的信息
		InputStream is = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len1;
		while((len1 = is.read(b1)) != -1){
			String str = new String(b1,0,len1);
			System.out.print(str);
		}
		//关闭相应的流和Socket对象
		is.close();
		os.close();
		fis.close();
		socket.close();
	}
	@Test
	public void server()throws Exception{
		//1.创建一个ServerSocket的对象
		ServerSocket ss = new ServerSocket(9898);
		//2.调用其accpet()方法，返回一个Socket对象
		Socket s = ss.accept();
		//3.将从客户端发来的信息保存到本地
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("2.jpg"));
		byte[]b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
		     fos.write(b,0,len);	
		}
		System.out.println("收到来自于" + s.getInetAddress().getHostAddress() + "");
		//4.发送“接收成功”的信息反馈给客户端
		OutputStream os = s.getOutputStream();
		os.write("你发送的图片我已接收成功！".getBytes());
	    //5.
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
   }

