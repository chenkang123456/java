package java����;
import java.util.Scanner; 
public class mulu {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int a = 0; //�Ƿ�ע��У��
		String answer;
		do{
		System.out.println("*****��ӭ����24����Ϸϵͳ*****");
		System.out.println("\t1.��¼\n\t2.����Ϸ\n\t3.���а�");
		System.out.println("��ѡ��˵���");
		int num = in.nextInt();
		if(a == 0 && num != 1){
		System.out.println("��δ��¼�����ȵ�¼");
		num = 1;
		}else if(a != 2 && num == 3){
		System.out.println("���ȵ�¼��");
		num = 2;
		}
		switch(num){
		case 1:
		System.out.println("[24����Ϸϵͳ>��¼]");
		a = 1; //�ѵ�¼;
		break;
		case 2:
		System.out.println("[24����Ϸϵͳ>����Ϸ]");
		a = 2; //�ѵ�¼;
		break;
		case 3:
		System.out.println("[24����Ϸϵͳ>���а�]");
		break;
		default:
		System.out.println("���������д���");
		break;
		}
		System.out.println("������y/n����");
		answer=in.next();
		System.out.println(" ");
		}while("y".equals(answer));
		System.out.println("ϵͳ�˳�,ллʹ��!");
		}

}
