
import java.util.Set;
/**
 * 
* Title: GetFoamat
* Description:   该类通过在循环中的a b c的值判断出当前所参与运算的值与参加运算的符号，假设四个值为n0,n1,n2,n3
* 形参 a、b、c为循环变量，形参n数组为参与运算的四个数字，形参op表示当前进行的运算类型，形参set为存储结果的容器

 */
public class DataFormat {
	public static void  judge(int a,int b,int c,float[]n,String op,Set<String> set) {
		StringBuilder sb = new StringBuilder();
		if(a==0) {//n0和n1 与n2和n3之间的运算
			if(b==0) {//n0+n1
				if(c==0) {//n2+n3
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[2]).append("+").append(n[3]).append(")").append("=24");
				}if(c==1) {//n2-n3
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[2]).append("-").append(n[3]).append(")").append("=24");
				}if(c==2) {//n3-n2
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[3]).append("-").append(n[2]).append(")").append("=24");
				}if(c==3) {// n2*n3
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[2]).append("*").append(n[3]).append(")").append("=24");
				}if(c==4) {// n2/n3
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[2]).append("/").append(n[3]).append(")").append("=24");
				}if(c==5) {// n3/n2
					sb.append("(").append(n[0]).append("+").append(n[1]).append(")").append(op).append("(").append(n[3]).append("/").append(n[2]).append(")").append("=24");
				}
				//将运算表达式存入容器
				set.add(sb.toString());
				//将sb清空
				sb = new StringBuilder();
			}if(b==1) {//n0-n1
			//由于这种代码篇幅比较长，在这里省略了，思路和上面的一致
			}
         }
	}
}