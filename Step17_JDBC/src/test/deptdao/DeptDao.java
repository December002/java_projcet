package test.deptdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.deptdto.DeptDto;
import test.util.DBConnect;

public class DeptDao {
	
	public DeptDto getData(int deptno) {
		DeptDto dto=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn=new DBConnect().getConn();
			
			//sql 문 작성란
			String sql="Select Dname, loc"
					+ " from dept"
					+ " where deptno=?";
			
			pstmt=conn.prepareStatement(sql);
			//select 문 ? 작성란
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				dto=new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
			}
		}catch(Exception e) {
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
	
	public List<DeptDto> getList(){
		List<DeptDto> list=new ArrayList<>();
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn=new DBConnect().getConn();
			
			//sql 문 작성란
			String sql="Select deptno, dname, loc"
					+ " from dept"
					+ " order by deptno desc";
			
			pstmt=conn.prepareStatement(sql);
			//select 문 ? 작성란
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				DeptDto  dto= new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto);	
			}
		}catch(Exception e) {
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
	
	
	public boolean insert(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			
			//sql문
			String sql="INSERT INTO dept"
					+ " (deptno, dname, loc)"
					+ " VALUES(?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			//? 작성란
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}	
	}	
	
	public boolean update(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			
			//sql문
			String sql="update dept"
					+ " set dname=?, loc=?"
					+ " where deptno=?";
			
			pstmt=conn.prepareStatement(sql);
			//? 작성란
			
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean delete(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int rowCount=0;
		try {
			conn=new DBConnect().getConn();
			
			//sql문
			String sql="Delete from dept"
					+ " where deptno=?";
			
			pstmt=conn.prepareStatement(sql);
			//? 작성란
			pstmt.setInt(1, dto.getDeptno());
			rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}	
	}
}
