package test.main;

import test.memberDao.MemberDao;
import test.memberDto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name="덩어리";
		String addr="목동";
		
		//추가할 회원 정보를 MemberDto 객체에 담는다.
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//DB에 저장하기
		new MemberDao().insert(dto);
	}
}
