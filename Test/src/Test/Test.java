package Test;

import static org.junit.Assert.*;

import java.util.Scanner;

public class Test {

	@org.junit.Test
	
public void test() {
		//����������
		
		int temp,p,r,i=0;
		System.out.println("������n1,n2");
		
		Scanner input=new Scanner(System.in);
		int n1 = input.nextInt();
        int n2 = input.nextInt();
		if(n1<n2){//ʹ��n1Ϊ�ϴ������n2Ϊ��С����
			temp=n1;
			n1=n2;
			n2=temp;
		}
		p=n1*n2;//pΪn1��n2�ĳ˻�
	    while(n2 !=0){//��n1��n2�����Լ��	   
		r=n1%n2;
		n1=n2;
		n2=r;
		i+=1;
	  }
	System.out.println("շת���ѭ��ִ�еĴ�����:"+i);

	System.out.println("���Լ��Ϊ��"+n1);
	
    System.out.println("��С������Ϊ��"+(p/n1));
   
   }      
}
