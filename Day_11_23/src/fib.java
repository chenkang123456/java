
public class fib {
	 public static void main(String[] args){
         int n = Integer.parseInt(args[0]);    //��String��ת��Ϊint��
         for(int i=1; i<=n; i++){
             System.out.print(fib(i)+" ");
         }
    }
    public static int fib(int num){
        if(num<=2){         //�ݹ����������
            return 1;
        }
        else{
            return fib(num-1)+fib(num-2);  //��n��쳲��������ǵ�n-1�͵�n-2֮��
        }
    }

}


