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

public class QuizMain2 extends JFrame {
	JTextField inputMsg1,inputMsg2,inputMsg3;
	
	public QuizMain2(String main) {
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
		
		 Connection conn=null;
	      
	      try {
	         //오라클 드라이버 로딩
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //접속할 DB 의 정보 @아이피주소:port번호:db이름
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         //계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         //예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
	         System.out.println("Oracle DB 접속 성공");
	      } catch (Exception e1) {
	         e1.printStackTrace();
	      }
		PreparedStatement pstmt=null;
	      try {
	    	  String sql="insert into member"
	    			  +" (num, name, addr)"
	    			  +" values(?, ?, ?)";
	    	  pstmt=conn.prepareStatement(sql);
	    	  pstmt.setInt(1, num);
	    	  pstmt.setString(2, name);
	    	  pstmt.setString(3, addr);
	    	  pstmt.executeUpdate();
	    	  System.out.println("회원의 정보를 추가하였습니다.");
	      }catch(Exception e1) {
	    	  e1.printStackTrace();
	      }
	});
	
	setVisible(true);
	}
	public static void main(String[] args) {
		new QuizMain2("회원등록");
		//DB 연결객체를 담을 지역 변수 만들기
	    
	}
}
