package quiz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener {
	public Quiz(String title) {
		super(title);

		
		
		setBounds(100, 100, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
	
		JTextField inputMsg1= new JTextField(10);
		JButton sendBtn1=new JButton("+");
		JButton sendBtn2=new JButton("-");
		JButton sendBtn3=new JButton("*");
		JButton sendBtn4=new JButton("/");
		JTextField inputMsg2= new JTextField(10);
		JLabel label= new JLabel();
		
		
		sendBtn1.addActionListener((e)->{
			double msg1= Double.parseDouble(inputMsg1.getText());
			double msg2 = Double.parseDouble(inputMsg2.getText());
			double sum1=msg1+msg2;
			String result1 =Double.toString(sum1);
			label.setText(result1);
			
			
		});
		
		sendBtn2.addActionListener((e)->{
			double msg1= Double.parseDouble(inputMsg1.getText());
			double msg2 = Double.parseDouble(inputMsg2.getText());
			double sum2=msg1-msg2;
			String result2 =Double.toString(sum2);
			label.setText(result2);
			
			
		});
		
		sendBtn3.addActionListener((e)->{
			double msg1= Double.parseDouble(inputMsg1.getText());
			double msg2 = Double.parseDouble(inputMsg2.getText());
			double sum3=msg1*msg2;
			String result3 =Double.toString(sum3);
			label.setText(result3);
			
			
		});
		
		sendBtn4.addActionListener((e)->{
			double msg1= Double.parseDouble(inputMsg1.getText());
			double msg2 = Double.parseDouble(inputMsg2.getText());
			double sum4=msg1/msg2;
			String result4 =Double.toString(sum4);
			label.setText(result4);
			
			
		});
		
		
		
		
		add(inputMsg1);
		add(sendBtn1);
		add(sendBtn2);
		add(sendBtn3);
		add(sendBtn4);
		add(inputMsg2);
		add(label);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Quiz("계산기");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}