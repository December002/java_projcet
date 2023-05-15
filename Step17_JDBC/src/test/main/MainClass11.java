package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		int num=3; //삭제할 회원의 번호라고 가정
		
		//아래의 delete() 메소드를 이용해서 회원 정보를 삭제해 보세요
		delete(num);
	}
	
	
	public static void delete(int num) {
		//인자로 전달된 num 에 해당되는 회원 정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용 하세요
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from member"
					+" where num=?";
			pstmt=conn.prepareCall(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("회원정보 삭제 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
