package java����;
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

            System.out.println("������Ҫ����ĵ�һ����.."); 

            float f1 = sc.nextFloat(); 

            System.out.println("���������+ - * /(Ĭ�ϲ�����Ϊ+)."); 

            char fu = '+'; 

            //String fuhao = next(); 

            try{ 

                char[] zhuan = sc.next().toCharArray(); 

                fu = zhuan[0]; 

            }catch(Exception e){System.out.println("������������");} 

            System.out.println("������Ҫ����ĵڶ�����.."); 

            float f2 = sc.nextFloat(); 
            System.out.println("���������+ - * /(Ĭ�ϲ�����Ϊ+)."); 

            char fu2 = '+'; 
            try{ 

                char[] zhuan = sc.next().toCharArray(); 

              fu = zhuan[0]; 
            }catch(Exception e){System.out.println("������������");} 
    
            System.out.println("������Ҫ����ĵ�������.."); 
            float f3 = sc.nextFloat(); 
          
            System.out.println("���������+ - * /(Ĭ�ϲ�����Ϊ+)."); 

            char fu3 = '+'; 

            //String fuhao = next(); 

            try{ 

                char[] zhuan = sc.next().toCharArray(); 

                fu = zhuan[0]; 

            }catch(Exception e){System.out.println("������������");} 

            System.out.println("������Ҫ����ĵ��ĸ���.."); 

            float f4 = sc.nextFloat(); 
                    
            switch(fu){ 

                case '+': 
                  sum = (int) (f1+f3+f3+f4);
                    System.out.println("�ӷ���" + (f1 + f2+f3+f4)); 

                break;
                
                case '-': 
                	sum = (int) (f1-f3-f3-f4);
                    System.out.println("������" + (f1 - f2-f3-f4)); 

                break; 

                case '/': 
                	sum = (int) (f1/f3/f3/f4);
                        if(f2 == 0){ 

                            System.out.println("����������Ϊ0"); 

                        }else{ 

                        System.out.println("������" + (f1 / f2/f3/f4)); 

                    } 

                break; 

                 case '*': 
                	 sum = (int) (f1*f3*f3*f4);
                    System.out.println("�˷���" + (f1 * f2*f3*f4)); 

                break; 

                default : 

                    System.out.println("�����ڵķ���"); 

            } 
            
                 

         }catch(Exception e){System.out.println("����������");} 
      
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
