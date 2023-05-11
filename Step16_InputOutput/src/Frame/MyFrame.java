package Frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	File f=new File("C:/acorn202304/myFolder/diary.txt");
	
	
	public MyFrame(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton textBtn=new JButton("텍스트 추가");
		JTextField textIn=new JTextField(10);
		
		add(textIn);
		add(textBtn);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	public static void main(String[] args) {
		new MyFrame("메모장");
	}
}
