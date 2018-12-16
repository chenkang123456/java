
import java.util.Scanner;

public class GuessNumber {
    public static void playGame() {
        //获取一个一到一百之间的随机数
        int random = (int) (Math.random()*100+1);

        //创建键盘录入对象，获取键盘录入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入所猜测的数字：");
        int number = sc.nextInt();

        //创建while死循环
        while (true) {
            if (number>random) {
                System.out.println("大了，请重新输入：");
                number = sc.nextInt();
            }
            if (number<random) {
                System.out.println("小了，请重新输入：");
                number=sc.nextInt();
            }
            if (number==random) {
                System.out.println("恭喜你答对了！");
                break;
            }
        }

    }

}
