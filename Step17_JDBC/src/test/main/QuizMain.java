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

public class QuizMain extends JFrame implements ActionListener {
	JTextField inputMsg1,inputMsg2,inputMsg3;
	
	public QuizMain(String main) {
		super(main);
	setBounds(100, 100, 700, 700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	

	inputMsg1= new JTextField(10);
	inputMsg2= new JTextField(10);
	inputMsg3= new JTextField(10);
	JButton saveBtn=new JButton("회원 추가");
	
	add(inputMsg1);
	add(inputMsg2);
	add(inputMsg3);
	add(saveBtn);
	
	saveBtn.addActionListener(this);
	saveBtn.setActionCommand("save");
	
	setVisible(true);
	}
	public static void main(String[] args) {
		new QuizMain("회원등록");
		//DB 연결객체를 담을 지역 변수 만들기
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
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      PreparedStatement pstmt=null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//inputMsg 1,2,3 의 내용을 saveBtn에 인식시켜야함
		String num=inputMsg1.getText();
		String name=inputMsg2.getText();
		String addr=inputMsg3.getText();

	}
}