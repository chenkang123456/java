package java����;

import java.util.Scanner;
public class main {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in );
		System.out.println("��Ϸ��ʼ");
		int score=0;
		for(int i=0;i<10;i++){
			int sum=0;
			int a=(int)(Math.random()*(8)+1);
			int b=(int)(Math.random()*(8)+1);
			int c=(int)(Math.random()*(8)+1);
			int d=(int)(Math.random()*(8)+1);
			String []fu=new String[3];
			
			System.out.println("n1\tn2\tn3\tn4");
			System.out.println(a+"\t"+b+"\t"+c+"\t"+d);

            Scanner sc=new Scanner(System.in);
            for(int j=0;j<fu.length;j++){
            	fu[j]=sc.next();
            }
            System.out.println(" "+fu[0]+" "+fu[1]+" "+fu[2]);
            
			switch(fu[0]){
			case "+":
				sum = a+b;
				break;
			case "-":
				if(a>b){
				sum = a-b;
				break;
				}
			case "*":
				sum = a*b;
				break;
			case "/":
				sum = a/b;
				break;
			default:
				System.out.println("������󣬷��Ų����ڣ�");
				break;
			}
			
			switch(fu[1]){
			case "+":
				sum += c;
				break;
			case "-":
				if(sum>c){
				sum -= c;
				break;
				}
			case "*":
				sum *= c;
				break;
			case "/":
				sum /= c;
				break;
			default:
					System.out.println("������󣬷��Ų����ڣ�");
				break;
			}
			
			switch(fu[2]){
			case "+":
				sum += d;
				break;
			case "-":
				if(sum>d){
					sum -= d;
				break;
				}
			case "*":
				sum *= d;
				break;
			case "/":
				sum /= d;
				break;
			default:
				System.out.println("������󣬷��Ų����ڣ�");
				break;
			}
			System.out.println(sum); 
            if(sum==24){
	              System.out.println("��ϲ��ش���ȷ������"); 
	              score=score+1;
	              System.out.println("�÷�Ϊ"  +score); 	              
            }else{
	              System.out.println("�ܱ�Ǹ��ش����"); 
            }           
        } 			
	}
}

