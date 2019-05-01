public class test02 {
    public static void main(String[] args){
        int flag =1;
        for(int i = 1;i<=100;i++) {
            for(int j = 2;j<100;j++) {
                if(i%j==0&i!=j) {
                    flag =0;
                    break;
                }
                else if(i==j)
                    System.out.println(i);
            }
        }

    }
}
