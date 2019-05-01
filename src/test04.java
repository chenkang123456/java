public class test04 {
    public static void main(String[] args) {
        int i,j;
        for(i=0;i<=1000;i++)
        {
            int sum=0;
            for(j=1;j<=i/2;j++)
            {
                if(i%j==0)
                    sum=sum+j;
            }
            if(sum==i)
                System.out.print(i+" ");
        }
    }
}
