import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestUDP {
	//���Ͷ�
@Test
public void send(){
	DatagramSocket ds = null;
	try {
		ds = new DatagramSocket();
		byte[] b = "��ã�����Ҫ���͵�����".getBytes();
		//����һ�����ݱ�
		DatagramPacket pack = new DatagramPacket(b,0,b.length,
				InetAddress.getByName("127.0.0.1"),9090);
		
		
		ds.send(pack);
	}  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(ds != null){
		ds.close();
	}	
  }
}
//���ն�
@Test
public void receive(){
	DatagramSocket ds = null;
	try {
		ds = new DatagramSocket(9090);
		byte[] b = new byte[1024];
		
		DatagramPacket pack = new DatagramPacket(b,0,b.length);
		ds.receive(pack);
		
		String str = new String(pack.getData(),0,pack.getLength());
		System.out.println(str);
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(ds != null){
			ds.close();
		}
	}
	
	
	
	
}
}
