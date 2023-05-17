package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.memberDto.MemberDto;
import test.util.DBConnect;

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
	      PreparedStatement pstmt=null;
	      try {
	    	  //Connection 객체의 참조값 얻어오기
	    	  conn=new DBConnect().getConn();
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
