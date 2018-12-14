package java代码;


	import java.util.ArrayList;
	import java.util.Scanner;

	public class Tfgame {
	    public static void main(String[] args) {
	    	//输入提示
	    	System.out.println("—————————欢迎进入24点游戏———————————");
	        //System.out.println("请随机输入四个1-9之间的整数（以空格隔开）：");
	        
	        ArrayList<Integer> list = inputNum();   //调用输入函数
	        tfCal(list, new ArrayList<String>());   //计算24点方法, 实参list为输入的数据, new ArrayList<String>()用来 表示计算过程
	        System.out.println("——————————————end———————————————");
	        
	    }
	    
	    //输入方法，将输入的四个数存入数组队列list中，并返回
	    private static ArrayList<Integer> inputNum() {
	        ArrayList<Integer> alist = new ArrayList<Integer>();  //ArrayList<Integer>表示只能接收整型数据
	        Scanner scanner = new Scanner(System.in);
	        for (int i = 0; i < 4; i++) {         //将四个数添加到数组队列中
	            alist.add(scanner.nextInt());
	        }
	        return alist;  //返回值为数组队列中的四个数
	    }

	    //计算24点游戏的方法
	    public static void tfCal(ArrayList<Integer> list, ArrayList<String> str) {
	        int length = list.size();    
	        if (length > 1) {
	        	/**利用双重循环取出两个数的计算所有情况
	        	 * 若list的长度为4，那么第一个数的下标和第二个数的下标分别为
	        	 * 0  1
	        	 * 1  2
	        	 * 2  3
	        	 */
	            for (int i = 0; i < length - 1; i++) {     
	                for (int j = i + 1; j < length; j++) {
	                    //加法运算
	                    int b = list.remove(j);  //移除list中的下标为j的元素，并将此数赋值给b
	                    int a = list.remove(i);  //同上，将值赋给a
	                    list.add(0, a + b);      //将两数的计算结果添加到原队列
	                    str.add(a + "+" + b + "=" + (a + b));//此处是保存计算的过程
	                    tfCal(list, str);    //递归调动
	                    //下面四句话是为了还原list队列，特别强调进栈和出栈的顺序
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //减运算(a-b)，原理与上面加法计算相同
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, a - b);
	                    str.add(a + "-" + b + "=" + (a - b));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //减运算(b-a)
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, b - a);
	                    str.add(b + "-" + a + "=" + (b - a));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //乘运算
	                    b = list.remove(j);
	                    a = list.remove(i);
	                    list.add(0, a * b);
	                    str.add(a + "*" + b + "=" + (a * b));
	                    tfCal(list, str);
	                    list.remove(0);
	                    list.add(i, a);
	                    list.add(j, b);
	                    str.remove(str.size() - 1);

	                    //除运算(a/b)
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

	                    //除运算(b/a)
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
	            if (str.get(str.size() - 1).endsWith("=24")) {   //endsWith()方法用于测试字符串是否以指定后缀结束
	        	   for (String temp : str) {
	                   System.out.print(temp + " ");
	               }  
	               System.out.println();
	            }               
	        }
	    }
	}

