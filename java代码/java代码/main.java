package java����;

import java.util.Scanner;
public class main {

static int result=24;
static int score=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in );
		System.out.println("��Ϸ��ʼ");
		for(int i=1;i<=10;i++){
			int max=9;
			int min=1;
			int a=(int)(Math.random()*(max-min));
			int b=(int)(Math.random()*(max-min));
			int c=(int)(Math.random()*(max-min));
			int d=(int)(Math.random()*(max-min));	
			
			System.out.println("n1\tn2\tn3\tn4");
			System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
			System.out.println("��������ʽ��");
			int input = in.nextInt();
	
            if(input==result){
	              System.out.println("��ϲ��ش���ȷ������"); 
	              score=score+1;
	              System.out.println("�÷�Ϊ"  +score); 
	              

            }else{
	              System.out.println("�ܱ�Ǹ��ش����"); 
            }           
        } 			
	}
}

