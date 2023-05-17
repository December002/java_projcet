package test.pak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.deptdto.DeptDto;
import test.util.DBConnect;

public class EmpDao {
	
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
}
