package MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.lang.model.element.NestingKind;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {
	public MyFrame2(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel p1=new JPanel();
		
		JTextField inputText=new JTextField(20);
		JButton saveBtn=new JButton("저장");
		
		p1.add(inputText);
		p1.add(saveBtn);
		
		add(p1, BorderLayout.NORTH);
		p1.setBackground(Color.YELLOW);
		
		JTextArea ta = new JTextArea();
		add(ta, BorderLayout.CENTER);
		
		JButton readBtn=new JButton("읽어오기");
		p1.add(readBtn);
		
		
		/*
	       *  읽어오기 버튼을 누르면 diary.txt 에 있는 모든 문자열을 읽어와서 
	       *  JTextArea 에 출력해 보세요.
	       *  
	       *  - hint 
	       *  FileReader 객체를 활용하면 파일에서 문자열을 읽어 낼수 있습니다.
	       */
		
		
		setVisible(true);
		
		File f = new File("C:\\acorn202304\\myFolder\\diary.txt");
		
		readBtn.addActionListener((e)->{
			FileReader fr=null;
			BufferedReader br=null;
			
		});
		
		saveBtn.addActionListener((e)->{
			String msg=inputText.getText();
			try {
				if(f.exists()) {
					f.createNewFile();
				}
				FileWriter fw=new FileWriter(f);
				fw.write(msg);
				fw.write("\r\n");
				fw.flush();
				fw.close();
				JOptionPane.showMessageDialog(this, "저장했습니다.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
	}
	public static void main(String[] args) {
		new MyFrame2("나의 프레임");
	}
}

