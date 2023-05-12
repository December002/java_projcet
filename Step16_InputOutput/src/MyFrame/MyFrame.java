package MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	File f=new File("C:/acorn202304/myFolder/diary.txt");
	
	
	public MyFrame(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//BorderLayout으로 설정
		setLayout(new BorderLayout());
		
		//UI 를 감쌀
		JPanel p1 = new JPanel();
	
		JTextField textIn=new JTextField(20);
		JButton textBtn=new JButton("텍스트 추가");
		
		//페널에 UI 를 추가
		p1.add(textIn);
		p1.add(textBtn);
		//패널을 프레임의 북쪽에 배치
		add(p1,BorderLayout.NORTH);
		//패널의 배경색
		p1.setBackground(Color.YELLOW);
		
		 JTextArea ta=new JTextArea();
		 add(ta,BorderLayout.CENTER);
		
		textBtn.addActionListener((e)->{
			String msg=textIn.getText();
			try {
				if(f.exists()) {
					FileWriter fw=new FileWriter(f, true);
					fw.write(msg);
					fw.flush();
					fw.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new MyFrame("메모장");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}
