package java´úÂë;
import java.util.Random;
import javax.swing.JOptionPane;
public class Test {
	
		public static void main(String[] args) 
	    {
		double x,a1,a2,a3,a4;
		
		Random rdm=new Random();
		a1=Math.abs(rdm.nextInt())%10+1; 
		System.out.println(a1);
		Random rdm2=new Random();
		a2=Math.abs(rdm2.nextInt())%10+1;
		System.out.println(a2);
		Random rdm3=new Random();
		a3=Math.abs(rdm2.nextInt())%10+1;
		System.out.println(a3);
		Random rdm4=new Random();
		a4=Math.abs(rdm.nextInt())%10+1; 
		System.out.println(a4);
		String str=JOptionPane.showInputDialog("plese input a number");
		x=Double.parseDouble(str);
		
		if(x==a1+a2+a3+a4)
		System.out.println("true");
		else
		System.out.println("false");
		
		}

}
