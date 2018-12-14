package java代码;
import java.util.Scanner; 
public class mulu {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int a = 0; //是否注册校验
		String answer;
		do{
		System.out.println("*****欢迎进入24分游戏系统*****");
		System.out.println("\t1.登录\n\t2.玩游戏\n\t3.排行榜");
		System.out.println("请选择菜单：");
		int num = in.nextInt();
		if(a == 0 && num != 1){
		System.out.println("您未登录，请先登录");
		num = 1;
		}else if(a != 2 && num == 3){
		System.out.println("请先登录！");
		num = 2;
		}
		switch(num){
		case 1:
		System.out.println("[24分游戏系统>登录]");
		a = 1; //已登录;
		break;
		case 2:
		System.out.println("[24分游戏系统>玩游戏]");
		a = 2; //已登录;
		break;
		case 3:
		System.out.println("[24分游戏系统>排行榜]");
		break;
		default:
		System.out.println("您的输入有错误");
		break;
		}
		System.out.println("继续吗（y/n）：");
		answer=in.next();
		System.out.println(" ");
		}while("y".equals(answer));
		System.out.println("系统退出,谢谢使用!");
		}

}
