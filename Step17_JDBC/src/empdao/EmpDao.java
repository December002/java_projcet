package empdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import empdto.EmpDto;
import test.deptdto.DeptDto;
import test.util.DBConnect;

public class EmpDao {
	public List<EmpDto> getList(){
		List<EmpDto> list=new ArrayList<>();
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn=new DBConnect().getConn();
			
			//sql 문 작성란
			String sql="Select empno, ename, deptno, job "
					+ " from emp"
					+ " order by empno asc";
			
			pstmt=conn.prepareStatement(sql);
			//select 문 ? 작성란
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				EmpDto dto=new EmpDto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setDeptno(rs.getInt("deptno"));
				dto.setJob(rs.getString("job"));
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
