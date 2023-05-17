package test.main;

import test.deptdao.DeptDao;
import test.deptdto.DeptDto;

public class DeptClass03 {
	public static void main(String[] args) {
		int deptno=50;
		String dname="누구게";
		String loc="어디게";
		DeptDto dto=new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		
		DeptDao dao=new DeptDao();
		boolean isInsert=dao.insert(dto);
		if(isInsert) {
			System.out.println("ff");
		}
	}
}
