package java代码;
import java.util.Random;
import javax.swing.JOptionPane;
public class Test {
	
	private static int fu;

	public static void main(String[] args){ 
    	
for(int i=1;i<=10;i++){
	
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int score=0;
      
        int max=9;
		int min=1;
		int a=(int)(Math.random()*(max-min));
		int b=(int)(Math.random()*(max-min));
		int c=(int)(Math.random()*(max-min));
		int d=(int)(Math.random()*(max-min));	
		
		System.out.println("n1\tn2\tn3\tn4");
		System.out.println(a+"\t"+b+"\t"+c+"\t"+d);

       int sum = 0;
	try{ 

            System.out.println("请输入要运算的第一个数.."); 

            float f1 = sc.nextFloat(); 

            System.out.println("输入运算符+ - * /(默认不输入为+)."); 

            char fu = '+'; 

            //String fuhao = next(); 

            try{ 

                char[] zhuan = sc.next().toCharArray(); 

                fu = zhuan[0]; 

            }catch(Exception e){System.out.println("运算符输入错误");} 

            System.out.println("请输入要运算的第二个数.."); 

            float f2 = sc.nextFloat(); 
            System.out.println("输入运算符+ - * /(默认不输入为+)."); 

            char fu2 = '+'; 
            try{ 

                char[] zhuan = sc.next().toCharArray(); 

              fu = zhuan[0]; 
            }catch(Exception e){System.out.println("运算符输入错误");} 
    
            System.out.println("请输入要运算的第三个数.."); 
            float f3 = sc.nextFloat(); 
          
            System.out.println("输入运算符+ - * /(默认不输入为+)."); 

            char fu3 = '+'; 

            //String fuhao = next(); 

            try{ 

                char[] zhuan = sc.next().toCharArray(); 

                fu = zhuan[0]; 

            }catch(Exception e){System.out.println("运算符输入错误");} 

            System.out.println("请输入要运算的第四个数.."); 

            float f4 = sc.nextFloat(); 
                    
            switch(fu){ 

                case '+': 
                  sum = (int) (f1+f3+f3+f4);
                    System.out.println("加法：" + (f1 + f2+f3+f4)); 

                break;
                
                case '-': 
                	sum = (int) (f1-f3-f3-f4);
                    System.out.println("减法：" + (f1 - f2-f3-f4)); 

                break; 

                case '/': 
                	sum = (int) (f1/f3/f3/f4);
                        if(f2 == 0){ 

                            System.out.println("被除数不能为0"); 

                        }else{ 

                        System.out.println("除法：" + (f1 / f2/f3/f4)); 

                    } 

                break; 

                 case '*': 
                	 sum = (int) (f1*f3*f3*f4);
                    System.out.println("乘法：" + (f1 * f2*f3*f4)); 

                break; 

                default : 

                    System.out.println("不存在的符号"); 

            } 
            
                 

         }catch(Exception e){System.out.println("请输入数字");} 
      
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
