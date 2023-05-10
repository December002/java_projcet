package frame04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		// setBounds(x, y, width, height) 창의 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);
		//이프레임(MyFrame)의 x 버튼 (close 버튼) 을 눌렀을때 프로세스도 같이 종료 되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//레이아웃 메니저는 아직 사용하지 않겠다 (모든 UI를 절대 좌표에 배치 하겠다)
		this.setLayout(null);
		
		//BorderLayout 매니저 사용해보기
		setLayout(new BorderLayout());
		
		JButton btn1 = new JButton("버튼1");
		// 프레임에 버튼 추가 하기
		add(btn1, BorderLayout.NORTH);
		
		JButton btn2 = new JButton("버튼2");
		// 프레임에 버튼 추가 하기
		add(btn2, BorderLayout.EAST);
		
		JButton btn3 = new JButton("버튼3");
		// 프레임에 버튼 추가 하기
		add(btn3, BorderLayout.SOUTH);
		
		JButton btn4 = new JButton("버튼4");
		// 프레임에 버튼 추가 하기
		add(btn4, BorderLayout.WEST);
		
		//프레임을 화면상에 실제 보이게 하기(false 하면 화면에 보이지 않는다)
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
