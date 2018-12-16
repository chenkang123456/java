import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Title: Test Description: 1. 采用随机数生成4个符合要求的数据，假设四个数据为n1,n2,n3,n4 。
 * 2．把数据相互组合可以得到如下组合：n1和n2 ，n1和n3，n1和n4，n2和n3，n2和n4。
 * 3．将上面的组合进行各种可能的运算例如：n1+n2，n1-n2，n2-n1，n1*n2，n1/n2，n2/n1等等。 
 * 4.把上面组合计算出来的结果存入进对应的数组中例如：组合相加的结果存入add数组，相减的结果存入sub数组……最终将这些数组存入一个list集合中，目的是为了方便通过循环遍历出每一种组合。
 * 5.通过循环去遍历每一种组合，把这些组合在一起进行相加，相减等运算，记录结果为24的表达式
 * @author jianglei
 */
public class Game {
	static Set<String> set = new HashSet<String>();// 使用Set存储算式表达式可以避免有重复的结果
	float[] data = new float[4];// 存放数据的集合
	float[] add = new float[6];// 存放组合相加的结果的集合
	float[] sub1 = new float[6];// 存放相减的结果（两个数相减的结果存在两种可能）
	float[] sub2 = new float[6];// 存放相减的结果
	float[] mul = new float[6];// 存放相乘
	float[] div1 = new float[6];// 存放相除（两个数相除的结果存在两种可能）
	float[] div2 = new float[6];// 存放相除
	List<float[]> list = new ArrayList<float[]>();// 存放组合结果运算的集合

	/**
	 * 
	 * Title: combine
	 * </p>
	 * Description: 该方法用来获取每两个数字的组合组合， 用1代表第一个数字，2代表第二个数字....共有六种组合方式，分别如下：
	 * 1和2,1和3,1和 4,2和 3,2和 4,3和 4 在上面的组合中，每一种组合都对应着 加减乘除 这四种运算
	 * 将上述的组合的每种计算结果存入上面声明的集合
	 */
	public void conbine(float n1, float n2, float n3, float n4) {
		add[0] = n1 + n2;
		add[1] = n1 + n3;
		add[2] = n1 + n4;
		add[3] = n2 + n3;
		add[4] = n2 + n4;
		add[5] = n3 + n4;

		sub1[0] = n1 - n2;
		sub1[1] = n1 - n3;
		sub1[2] = n1 - n4;
		sub1[3] = n2 - n3;
		sub1[4] = n2 - n4;
		sub1[5] = n3 - n4;
		sub1[5] = n3 + n4;

		sub2[0] = n2 - n1;
		sub2[1] = n3 - n1;
		sub2[2] = n4 - n1;
		sub2[3] = n3 - n2;
		sub2[4] = n4 - n2;
		sub2[5] = n4 - n3;

		mul[0] = n2 * n1;
		mul[1] = n3 * n1;
		mul[2] = n4 * n1;
		mul[3] = n3 * n2;
		mul[4] = n4 * n2;
		mul[5] = n4 * n3;

		div1[0] = n1 / n2;
		div1[1] = n1 / n3;
		div1[2] = n1 / n4;
		div1[3] = n2 / n3;
		div1[4] = n2 / n4;
		div1[5] = n3 / n4;

		div2[0] = n2 / n1;
		div2[1] = n3 / n1;
		div2[2] = n4 / n1;
		div2[3] = n3 / n2;
		div2[4] = n4 / n2;
		div2[5] = n4 / n3;

		list.add(add);// 把各种组合加入到list集合中，方便通过循环来遍历每一种组合方式
		list.add(sub1);
		list.add(sub2);
		list.add(mul);
		list.add(div1);
		list.add(div2);
	}

	public void getData() {
		Random r = new Random();
		// 获取1——13的的数字的集合
		data[0] = r.nextInt(12) + 1;
		data[1] = r.nextInt(12) + 1;
		data[2] = r.nextInt(12) + 1;
		data[3] = r.nextInt(12) + 1;
		System.out.print("四个数字为：");
		for (float f : data)
			switch ((int) f) {// 将11,12,13,1变成J,Q,K,A
			case 1:
				System.out.print("A" + " ");
				break;
			case 11:
				System.out.print("J" + " ");
				break;
			case 12:
				System.out.print("O" + " ");
				break;
			case 13:
				System.out.print("K" + " ");
				break;
			default:
				System.out.print((int) f + " ");
				break;
			}
		System.out.println();
		boolean flag = false;// 通过该变量去判断是否存在表达式
		conbine(data[0], data[1], data[2], data[3]);
		for (int a = 0; a < 3; a++) {// 有种组合方式，分别遍历每一种组合方法
			for (int b = 0; b < 6; b++) {// 穷举每一个组合和他们之间的运算
				for (int c = 0; c < 6; c++) {// 判断每一种组合的每一种运算结果是否等于24
					if ((list.get(b)[a] + list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "+", set);
						flag = true;
					}
					// 减法
					if ((list.get(b)[a] - list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "-", set);
					}
					if ((list.get(b)[5 - a] - list.get(c)[a]) == 24) {
						DataFormat.judge(a, b, c, data, "-", set);
						flag = true;
					}
					// 乘法
					if ((list.get(b)[a] * list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "*", set);
						flag = true;
					}
					// 除法
					if ((list.get(b)[a] / list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "/", set);
						flag = true;
					}
					if ((list.get(b)[5 - a] / list.get(c)[a]) == 24) {
						DataFormat.judge(a, b, c, data, "/", set);
						flag = true;
					}
				}
			}
		}
		if (!flag)
			System.out.println("没有表达式满足条件");
	}
}