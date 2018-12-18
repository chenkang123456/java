package Test;

import static org.junit.Assert.*;

import java.util.Scanner;

public class Test {

	@org.junit.Test
	
public void test() {
		//测试用例：
		
		int temp,p,r,i=0;
		System.out.println("请输入n1,n2");
		
		Scanner input=new Scanner(System.in);
		int n1 = input.nextInt();
        int n2 = input.nextInt();
		if(n1<n2){//使得n1为较大的数，n2为较小的数
			temp=n1;
			n1=n2;
			n2=temp;
		}
		p=n1*n2;//p为n1与n2的乘积
	    while(n2 !=0){//求n1与n2的最大公约数	   
		r=n1%n2;
		n1=n2;
		n2=r;
		i+=1;
	  }
	System.out.println("辗转相除循环执行的次数是:"+i);

	System.out.println("最大公约数为："+n1);
	
    System.out.println("最小公倍数为："+(p/n1));
   
   }      
}
