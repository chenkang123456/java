
import java.util.Set;
/**
 * 
* Title: GetFoamat
* Description:   ����ͨ����ѭ���е�a b c��ֵ�жϳ���ǰ�����������ֵ��μ�����ķ��ţ������ĸ�ֵΪn0,n1,n2,n3
* �β� a��b��cΪѭ���������β�n����Ϊ����������ĸ����֣��β�op��ʾ��ǰ���е��������ͣ��β�setΪ�洢���������

 */
public class DataFormat {
	public static void  judge(int a,int b,int c,float[]n,String op,Set<String> set) {
		StringBuilder sb = new StringBuilder();
		if(a==0) {//n0��n1 ��n2��n3֮�������
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
				//��������ʽ��������
				set.add(sb.toString());
				//��sb���
				sb = new StringBuilder();
			}if(b==1) {//n0-n1
			//�������ִ���ƪ���Ƚϳ���������ʡ���ˣ�˼·�������һ��
			}
         }
	}
}