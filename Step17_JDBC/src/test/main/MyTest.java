package test.main;

import java.util.List;

import empdao.EmpDao;
import empdto.EmpDto;
import test.memberDao.MemberDao;
import test.memberDto.MemberDto;

public class MyTest {
	public static void main(String[] args) {
		//모든 회원의 정보를 얻어오고 싶다면?
		List<EmpDto> list=new EmpDao().getList();
		//얻어와서 뭘하지 콘솔창에 출력
		for(EmpDto tmp:list) {
			System.out.println(tmp.getEmpno()+" | "+tmp.getEname()+" | "+tmp.getDeptno()+" | "+tmp.getJob());
		}
	}
}
