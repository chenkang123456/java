package java����;


	import java.util.ArrayList;
	import java.util.Scanner;

	public class Tfgame {
	    public static void main(String[] args) {
	    	//������ʾ
	    	System.out.println("��������������������ӭ����24����Ϸ����������������������");
	        //System.out.println("����������ĸ�1-9֮����������Կո��������");
	        
	        ArrayList<Integer> list = inputNum();   //�������뺯��
	        tfCal(list, new ArrayList<String>());   //����24�㷽��, ʵ��listΪ���������, new ArrayList<String>()���� ��ʾ�������
	        System.out.println("����������������������������end������������������������������");
	        
	    }
	    
	    //���뷽������������ĸ��������������list�У�������
	    private static ArrayList<Integer> inputNum() {
	        ArrayList<Integer> alist = new ArrayList<Integer>();  //ArrayList<Integer>��ʾֻ�ܽ�����������
	        Scanner scanner = new Scanner(System.in);
	        for (int i = 0; i < 4; i++) {         //���ĸ�����ӵ����������
	            alist.add(scanner.nextInt());
	        }
	        return alist;  //����ֵΪ��������е��ĸ���
	    }

	    //����24����Ϸ�ķ���
	    public static void tfCal(ArrayList<Integer> list, ArrayList<String> str) {
	        int length = list.size();    
	        if (length > 1) {
	        	/**����˫��ѭ��ȡ���������ļ����������
	        	 * ��list�ĳ���Ϊ4����ô��һ�������±�͵ڶ��������±�ֱ�Ϊ
	        	 * 0  1
	        	 * 1  2
	        	 * 2  3
	        	 */
	            for (int i = 0; i < length - 1; i++) {     
	                for (int j = i + 1; j < length; j++) {
	                    //�ӷ�����
	                    int b = list.remove(j);  //�Ƴ�list�е��±�Ϊj��Ԫ�أ�����������ֵ��b
	                    int a = list.remove(i);  //ͬ�ϣ���ֵ����a
	                    list.add(0, a + b);      //�������ļ�������ӵ�ԭ����
	                    str.add(a + "+" + b + "=" + (a + b));//�˴��Ǳ������Ĺ���
	                    tfCal(list, str);    //�ݹ����
	                    //�����ľ仰��Ϊ�˻�ԭlist���У��ر�ǿ����ջ�ͳ�ջ��˳��
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //������(a-b)��ԭ��������ӷ�������ͬ
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, a - b);
	                    str.add(a + "-" + b + "=" + (a - b));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //������(b-a)
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, b - a);
	                    str.add(b + "-" + a + "=" + (b - a));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //������
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, a * b);
	                    str.add(a + "*" + b + "=" + (a * b));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //������(a/b)
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    if (b != 0 && a % b == 0) {
	                        list.add(0, a / b);
	                        str.add(a + "/" + b + "=" + (a / b));
	                        tfCal(list, str);
	                        list.remove(0);
	                        list.add(i, a);
	                        list.add(j, b);
	                        str.remove(str.size() - 1);
	                    } else {
	                        list.add(i, a);
	                        list.add(j, b);
	                    }

	                    //������(b/a)
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    if (a != 0 && b % a == 0) {
	                        list.add(0, b / a);
	                        str.add(b + "/" + a + "=" + (b / a));
	                        tfCal(list, str);
	                        list.remove(0);
	                        list.add(i, a);
	                        list.add(j, b);
	                        str.remove(str.size() - 1);
	                    } else {
	                        list.add(i, a);
	                        list.add(j, b);
	                    }
	                }
	            }
	        } else {
	            if (str.get(str.size() - 1).endsWith("=24")) {   //endsWith()�������ڲ����ַ����Ƿ���ָ����׺����
	        	   for (String temp : str) {
	                   System.out.print(temp + " ");
	               }  
	               System.out.println();
	            }               
	        }
	    }
	}

