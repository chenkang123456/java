
import java.io.*;
import java.net.*;public class ftpServer extends Thread{ public static void main(String args[]){
 String initDir;
 initDir = "D:/Ftp";
 ServerSocket server;
 Socket socket;
 String s;
 String user;
 String password;
 user = "root";
 password = "123456";
 try{
 System.out.println("MYFTP服务器启动....");
 System.out.println("正在等待连接....");
 //监听21号端口
 server = new ServerSocket(21);
 socket = server.accept();
 System.out.println("连接成功");
 System.out.println("**********************************");
 System.out.println("");
 
 InputStream in =socket.getInputStream();
 OutputStream out = socket.getOutputStream();
 
 DataInputStream din = new DataInputStream(in);
 DataOutputStream dout=new DataOutputStream(out);
 System.out.println("请等待验证客户信息....");
 
 while(true){
  s = din.readUTF();
  if(s.trim().equals("LOGIN "+user)){
   s = "请输入密码:";
   dout.writeUTF(s);
   s = din.readUTF();
   if(s.trim().equals(password)){
    s = "连接成功。";
    dout.writeUTF(s);
    break;
   }
   else{s ="密码错误，请重新输入用户名：";   dout.writeUTF(s);      }
   }
  else{
   s = "您输入的命令不正确或此用户不存在，请重新输入：";
   dout.writeUTF(s);
   }
 }
 System.out.println("验证客户信息完毕...."); while(true){
  System.out.println("");
  System.out.println("");
  s = din.readUTF();
  if(s.trim().equals("DIR")){
   String output = "";  
   File file = new File(initDir);
   String[] dirStructure = new String[10];
   dirStructure= file.list();
   for(int i=0;i<dirStructure.length;i++){
    output +=dirStructure[i]+"\n";
   }
   s=output;
   dout.writeUTF(s);
  }
  else if(s.startsWith("GET")){
   s = s.substring(3);
   s = s.trim();
   File file = new File(initDir);
   String[] dirStructure = new String[10];
   dirStructure= file.list();
   String e= s;
   int i=0;
   s ="不存在";
   while(true){
    if(e.equals(dirStructure[i])){
      s="存在";
      dout.writeUTF(s);
      RandomAccessFile outFile = new RandomAccessFile(initDir+"/"+e,"r");
      byte byteBuffer[]= new byte[1024];
      int amount;
      while((amount = outFile.read(byteBuffer)) != -1){
      dout.write(byteBuffer, 0, amount);break;
      }break;
      
     }
    else if(i<dirStructure.length-1){
     i++;
     }
     else{
      dout.writeUTF(s);
     break;
     }
     }
   }
  else if(s.startsWith("PUT")){
   s = s.substring(3);
   s = s.trim();
   RandomAccessFile inFile = new RandomAccessFile(initDir+"/"+s,"rw");
   byte byteBuffer[] = new byte[1024];
   int amount;
   while((amount =din.read(byteBuffer) )!= -1){
   inFile.write(byteBuffer, 0, amount);break;
  }
  }
  else if(s.trim().equals("BYE"))break;
  else{
   s = "您输入的命令不正确或此用户不存在，请重新输入：";
   dout.writeUTF(s);
 }
 } 
  
 din.close();
 dout.close();
 in.close();
 out.close();
 socket.close();
}
catch(Exception e){
 System.out.println("MYFTP关闭!"+e);
 
}
}}