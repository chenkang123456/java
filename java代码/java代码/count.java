package java����;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class count {
	
public static void main(String[] args) {
	
final String userName = "abc";
final String passwrod = "1+2+3+4";
JFrame jFrame = new JFrame("��Ϸ����");
Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
jFrame.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 200, 150);
jFrame.setResizable(false);
jFrame.setLayout(null);
jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label1 = new JLabel("����");
label1.setBounds(10, 10, 100, 30);
jFrame.add(label1);

JLabel label2 = new JLabel("����");
label2.setBounds(10, 40, 100, 30);
jFrame.add(label2);

final JTextField text1 = new JTextField();
text1.setBounds(50, 15, 130, 20);
jFrame.add(text1);

final JPasswordField text2 = new JPasswordField();
text2.setBounds(50, 45, 130, 20);
jFrame.add(text2);

JButton button = new JButton("count");
button.setBounds(10, 75, 170, 40);
button.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
if(userName.equals(text1.getText()) && passwrod.equals(text2.getText())) {
JOptionPane.showMessageDialog(null, "�ش���ȷ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
} else {
JOptionPane.showMessageDialog(null, "�ش����", "��ʾ", JOptionPane.ERROR_MESSAGE);
text1.setText("");
text2.setText("");
}
}
});
jFrame.add(button);

jFrame.setVisible(true);

}

}