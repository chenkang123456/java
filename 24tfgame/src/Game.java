import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Title: Test Description: 1. �������������4������Ҫ������ݣ������ĸ�����Ϊn1,n2,n3,n4 ��
 * 2���������໥��Ͽ��Եõ�������ϣ�n1��n2 ��n1��n3��n1��n4��n2��n3��n2��n4��
 * 3�����������Ͻ��и��ֿ��ܵ��������磺n1+n2��n1-n2��n2-n1��n1*n2��n1/n2��n2/n1�ȵȡ� 
 * 4.��������ϼ�������Ľ���������Ӧ�����������磺�����ӵĽ������add���飬����Ľ������sub���顭�����ս���Щ�������һ��list�����У�Ŀ����Ϊ�˷���ͨ��ѭ��������ÿһ����ϡ�
 * 5.ͨ��ѭ��ȥ����ÿһ����ϣ�����Щ�����һ�������ӣ���������㣬��¼���Ϊ24�ı��ʽ
 * @author jianglei
 */
public class Game {
	static Set<String> set = new HashSet<String>();// ʹ��Set�洢��ʽ���ʽ���Ա������ظ��Ľ��
	float[] data = new float[4];// ������ݵļ���
	float[] add = new float[6];// ��������ӵĽ���ļ���
	float[] sub1 = new float[6];// �������Ľ��������������Ľ���������ֿ��ܣ�
	float[] sub2 = new float[6];// �������Ľ��
	float[] mul = new float[6];// ������
	float[] div1 = new float[6];// ������������������Ľ���������ֿ��ܣ�
	float[] div2 = new float[6];// ������
	List<float[]> list = new ArrayList<float[]>();// �����Ͻ������ļ���

	/**
	 * 
	 * Title: combine
	 * </p>
	 * Description: �÷���������ȡÿ�������ֵ������ϣ� ��1�����һ�����֣�2����ڶ�������....����������Ϸ�ʽ���ֱ����£�
	 * 1��2,1��3,1�� 4,2�� 3,2�� 4,3�� 4 �����������У�ÿһ����϶���Ӧ�� �Ӽ��˳� ����������
	 * ����������ϵ�ÿ�ּ������������������ļ���
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

		list.add(add);// �Ѹ�����ϼ��뵽list�����У�����ͨ��ѭ��������ÿһ����Ϸ�ʽ
		list.add(sub1);
		list.add(sub2);
		list.add(mul);
		list.add(div1);
		list.add(div2);
	}

	public void getData() {
		Random r = new Random();
		// ��ȡ1����13�ĵ����ֵļ���
		data[0] = r.nextInt(12) + 1;
		data[1] = r.nextInt(12) + 1;
		data[2] = r.nextInt(12) + 1;
		data[3] = r.nextInt(12) + 1;
		System.out.print("�ĸ�����Ϊ��");
		for (float f : data)
			switch ((int) f) {// ��11,12,13,1���J,Q,K,A
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
		boolean flag = false;// ͨ���ñ���ȥ�ж��Ƿ���ڱ��ʽ
		conbine(data[0], data[1], data[2], data[3]);
		for (int a = 0; a < 3; a++) {// ������Ϸ�ʽ���ֱ����ÿһ����Ϸ���
			for (int b = 0; b < 6; b++) {// ���ÿһ����Ϻ�����֮�������
				for (int c = 0; c < 6; c++) {// �ж�ÿһ����ϵ�ÿһ���������Ƿ����24
					if ((list.get(b)[a] + list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "+", set);
						flag = true;
					}
					// ����
					if ((list.get(b)[a] - list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "-", set);
					}
					if ((list.get(b)[5 - a] - list.get(c)[a]) == 24) {
						DataFormat.judge(a, b, c, data, "-", set);
						flag = true;
					}
					// �˷�
					if ((list.get(b)[a] * list.get(c)[5 - a]) == 24) {
						DataFormat.judge(a, b, c, data, "*", set);
						flag = true;
					}
					// ����
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
			System.out.println("û�б��ʽ��������");
	}
}