
package count;
/*

* ����һ����Game��ʯͷ��������������Ϸ��

*/

public class Game {

/**

* @param args

*/

	String[] s ={"ʯͷ","����","��"};

//��ȡ���Գ�ȭ

String getComputer(int i)

{

String computerGuess = s[i];

return computerGuess;

}

//�ж��˳�ȭ�Ƿ�Ϊʯͷ����������

boolean isOrder(String guess)

{

boolean m = false;

for(int x = 0;x < s.length; x++)

{

		if(guess.equals(s[x]))

		{

		m = true;

		break;

		}

		}

		return m;

		}

		//�Ƚ�

		void winOrLose(String guess1,String guess2)

		{

		if(guess1.equals(guess2))

		{

		System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��ƽ��");

		}else if(guess1.equals("ʯͷ"))

		{

			if(guess2.equals("����"))

			{

			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��You Win!");

			
			}

			else
			{

			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��You Lose!");

			}

			}else if(guess1.equals("(����"))

			{

			if(guess2.equals("��"))

			{

			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��You Win!");

			}else

			{

			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��You Lose!");

			}

			}else if(guess1.equals("��"))

			{

			if(guess2.equals("ʯͷ"))

			{



			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + " You Win!");

			}else

			{

			System.out.println("���:" + guess1 + "�����Գ�:" + guess2 + "��You Lose!");

			}

			}

			}

		
		public static void main(String[] args) {

		Game my = new Game();

		Game computer = new Game();

		Game game = new Game();

		String myGuess = javax.swing.JOptionPane.showInputDialog("����ʯͷ����������:");



		String computerGuess = computer.getComputer((int)(Math.floor(Math.random()*3)));

		if(my.isOrder(myGuess))

		{

		game.winOrLose(myGuess, computerGuess);

		}else



		

		{

		System.out.println("������Ĳ���ʯͷ������������");

		}

		}

		}

	