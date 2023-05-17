package test.main;

import java.util.Scanner;

import test.deptdao.DeptDao;
import test.deptdto.DeptDto;

public class DeptClass02 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("검색할 부서번호 입력:");
		int deptno=scan.nextInt();
		DeptDto dto=new DeptDao().getData(deptno);
		if(dto!=null) {
			System.out.println("부서 번호:"+dto.getDeptno()+" 부서 이름:"+dto.getDname()+" 부서 위치"+dto.getLoc());
		}else {
			System.out.println("존재하지 않는 부서 번호 입니다");
		}
		
	}
}
