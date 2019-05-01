public class test01 {
    public static void main(String[] args){
        long sum = 0,num = 1;
        for (int i = 1;i <= 10;i++){
            num = num * i;
            sum = sum + num;

        }
        System.out.println(" " +sum);
    }
}
