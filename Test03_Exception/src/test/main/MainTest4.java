package test.main;

import java.util.Random;

public class MainTest4 {
	public static void main(String[] args) {
		Random ran=new Random();
		
		int ranNum=ran.nextInt(5);
	}
	//0~4 사이의 랜덤한 정수 얻어내기
	//우연히 가장 큰수가 나오면 WowException 을 발생시키기
	//throw 예약어와 함께 예외 객체를 생성하면 예외가 발생한다.
}
