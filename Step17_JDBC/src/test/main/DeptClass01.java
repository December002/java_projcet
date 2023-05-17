package test.main;

import java.util.ArrayList;
import java.util.List;

import test.deptdao.DeptDao;
import test.deptdto.DeptDto;

public class DeptClass01 {
	public static void main(String[] args) {
		List<DeptDto> list=new DeptDao().getList();
		
		for(DeptDto tmp:list) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
	}
}
