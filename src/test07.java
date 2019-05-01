
import java.util.Scanner;

public class test07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个1~100之间的整数！");
        int j = (int) (Math.random() * 100 + 1);
        while (true) {
            int i = scan.nextInt();
            if (i > j) {
                System.out.println("您猜的数大了");
                System.out.println("请继续输入！");
            } else if (i < j) {
                System.out.println("您猜的数小了");
                System.out.println("请继续输入！");
            } else{
                System.out.println("恭喜您猜对了");
                System.out.println("这个数是："+i);
                break;
            }
        }
    }
}
