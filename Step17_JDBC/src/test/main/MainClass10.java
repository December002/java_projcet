package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num=1;
		String name="호빵";
		String addr="독산동";
		
		MemberDto dto1=new MemberDto();
		
		dto1.setName(name);
		dto1.setAddr(addr);
		dto1.setNum(num);
		
		update(dto1);
	}
	
	public static void update(MemberDto dto) {
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
	      try {
	    	  
	    	  String sql="update member"
	    			  +" set name=?, addr=?"
	    			  +" where num=?";
	    	  pstmt=conn.prepareStatement(sql);
	    	  pstmt.setString(1, dto.getName());
	    	  pstmt.setString(2, dto.getAddr());
	    	  pstmt.setInt(3, dto.getNum());
	    	  pstmt.executeUpdate();
	    	  System.out.println("수정 완료됨");
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
