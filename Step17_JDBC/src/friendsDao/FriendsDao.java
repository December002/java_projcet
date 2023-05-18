package friendsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import friendsDto.FriendsDto;
import test.util.DBConnect;

public class FriendsDao {
	public FriendsDto getData(int num){
		FriendsDto dto=new FriendsDto();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="SELECT name, nick"
					+ " From friends"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String nick=rs.getString("nick");
				dto=new FriendsDto();
				dto.setName(name);
				dto.setNum(num);
				dto.setNick(nick);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return dto;
	}
	
	
	public List<FriendsDto> getList(){
		List<FriendsDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			//sql 문 작성란
			String sql="Select num, name, nick"
					+ " from friends"
					+ " order by num desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FriendsDto dto= new FriendsDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			//작성할 sql 문
			String sql="DELETE from friends"
					+ " where num=?";
			
			pstmt=conn.prepareStatement(sql);
			//sql 문에서의 ? 작성란
			pstmt.setInt(1, num);
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(FriendsDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			//작성할 sql 문
			String sql="update friends"
					+ " Set name=?, nick=?"
					+ " where num=?";
			
			pstmt=conn.prepareStatement(sql);
			//sql 문에서의 ? 작성란
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getNick());
			pstmt.setInt(3, dto.getNum());
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean insert(FriendsDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			//작성할 sql 문
			String sql="INSERT INTO friends"
					+ " (num, name, nick)"
					+ " values(friends_seq.nextval, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			//sql 문에서의 ? 작성란
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getNick());
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
}
