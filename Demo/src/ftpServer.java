
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
 System.out.println("MYFTP����������....");
 System.out.println("���ڵȴ�����....");
 //����21�Ŷ˿�
 server = new ServerSocket(21);
 socket = server.accept();
 System.out.println("���ӳɹ�");
 System.out.println("**********************************");
 System.out.println("");
 
 InputStream in =socket.getInputStream();
 OutputStream out = socket.getOutputStream();
 
 DataInputStream din = new DataInputStream(in);
 DataOutputStream dout=new DataOutputStream(out);
 System.out.println("��ȴ���֤�ͻ���Ϣ....");
 
 while(true){
  s = din.readUTF();
  if(s.trim().equals("LOGIN "+user)){
   s = "����������:";
   dout.writeUTF(s);
   s = din.readUTF();
   if(s.trim().equals(password)){
    s = "���ӳɹ���";
    dout.writeUTF(s);
    break;
   }
   else{s ="������������������û�����";   dout.writeUTF(s);      }
   }
  else{
   s = "������������ȷ����û������ڣ����������룺";
   dout.writeUTF(s);
   }
 }
 System.out.println("��֤�ͻ���Ϣ���...."); while(true){
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
   s ="������";
   while(true){
    if(e.equals(dirStructure[i])){
      s="����";
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
   s = "������������ȷ����û������ڣ����������룺";
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
 System.out.println("MYFTP�ر�!"+e);
 
}
}}