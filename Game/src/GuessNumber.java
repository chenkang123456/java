
import java.util.Scanner;

public class GuessNumber {
    public static void playGame() {
        //��ȡһ��һ��һ��֮��������
        int random = (int) (Math.random()*100+1);

        //��������¼����󣬻�ȡ����¼������
        Scanner sc = new Scanner(System.in);
        System.out.println("���������²�����֣�");
        int number = sc.nextInt();

        //����while��ѭ��
        while (true) {
            if (number>random) {
                System.out.println("���ˣ����������룺");
                number = sc.nextInt();
            }
            if (number<random) {
                System.out.println("С�ˣ����������룺");
                number=sc.nextInt();
            }
            if (number==random) {
                System.out.println("��ϲ�����ˣ�");
                break;
            }
        }

    }

}
