package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class QuizMain3 extends JFrame {
	JTextField inputMsg1,inputMsg2,inputMsg3;
	
	public QuizMain3(String main) {
		super(main);
	setBounds(100, 100, 700, 700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	

	JTextField inputMsg1= new JTextField(10);
	JTextField inputMsg2= new JTextField(10);
	JTextField inputMsg3= new JTextField(10);
	JButton saveBtn=new JButton("회원 추가");
	
	add(inputMsg1);
	add(inputMsg2);
	add(inputMsg3);
	add(saveBtn);
	
	saveBtn.addActionListener((e)->{
		String num1=inputMsg1.getText();
		String name=inputMsg2.getText();
		String addr=inputMsg3.getText();
		
		int num=Integer.parseInt(num1);
		
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		new MemberDao().insert(dto);
	});
	
	setVisible(true);
	}
	public static void main(String[] args) {
		new QuizMain3("회원등록");
		//DB 연결객체를 담을 지역 변수 만들기
	    
	}
}
