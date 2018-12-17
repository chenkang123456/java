package java代码;

import java.util.Scanner;

public class Swich {
	public static void main(String[] args){
	int score=0;
	for(int j=0;j<10;j++){
        int sum=0; 
        
		int a=(int)(Math.random()*(8)+1);
		int b=(int)(Math.random()*(8)+1);
		int c=(int)(Math.random()*(8)+1);
		int d=(int)(Math.random()*(8)+1);	
		String []fu=new String[3];
		
		System.out.println("n1\tn2\tn3\tn4");
		System.out.println(a+"\t"+b+"\t"+c+"\t"+d);

			Scanner sc = new Scanner(System.in);
			for(int i=0;i<fu.length;i++){
				fu[i]=sc.next();
			}
				
        System.out.println(" "+fu[0]+" "+fu[1]+" "+fu[2]);

		  switch(fu[0]){ 

          case "+": 
            sum = a+b;

          break;
          
          case "-": 
        	  if(a>b){
        	sum = a-b;
        	  }
          break; 
          case "*":
        	sum =a*b;
         
          break;
          case "/":
        	sum =a/b;
        	  break;
          default : 

              System.out.println("不存在的符号"); 

        } 
		  
		  switch(fu[1]){ 

          case "+": 
            sum +=c;

          break;
          
          case "-": 
        	  if(sum>c){
        	sum -= c;
        	  }
          break; 
          case "*":
        	sum*=c;        
         break;
          case "/":
            sum /=c;
          break;
          
          default : 

              System.out.println("不存在的符号"); 
         } 
		  
		  switch(fu[2]){
		  case "+": 
	            sum +=d;

	          break;
	          
	          case "-": 
	        	  if(sum>d){
	        	sum -= d;
	        	  }
	          break; 
	          case "*":
	        	sum*=d;        
	         break;
	          case "/":
	            sum /=d;
	          break;
	          
	          default : 

	              System.out.println("不存在的符号"); 

		  }
		  
		  System.out.println(sum); 
		  if(sum==24){
	           System.out.println("恭喜你回答正确！！！"); 
	           score=score+1;
	           System.out.println("得分为"  +score); 
	      }else{
	           System.out.println("很抱歉你回答错了"); 
	           
	   }           
	 }
   }
}
