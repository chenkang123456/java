package java代码;

import java.util.Scanner;
public class main {

static int result=24;
static int score=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in );
		System.out.println("游戏开始");
		for(int i=1;i<=10;i++){
			int max=9;
			int min=1;
			int a=(int)(Math.random()*(max-min));
			int b=(int)(Math.random()*(max-min));
			int c=(int)(Math.random()*(max-min));
			int d=(int)(Math.random()*(max-min));	
			
			System.out.println("n1\tn2\tn3\tn4");
			System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
			System.out.println("请输入表达式：");
			int input = in.nextInt();
	
            if(input==result){
	              System.out.println("恭喜你回答正确！！！"); 
	              score=score+1;
	              System.out.println("得分为"  +score); 
	              

            }else{
	              System.out.println("很抱歉你回答错了"); 
            }           
        } 			
	}
}

