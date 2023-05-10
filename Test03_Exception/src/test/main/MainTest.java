package test.main;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//숫자 형식의 문자열을 입력 받는다. "10" "20" "10.1" 등등
		System.out.print("숫자를 입력하세요 : ");
		String strNum=scan.nextLine();
		try {
		//입력한 숫자를(문자열) 실제 숫자로 바꾼다.
		double num=Double.parseDouble(strNum);
		//입력한 숫자에 100을 더한다.
		double result=num+100;
		System.out.println("입력한 숫자 + 100 : "+result);
		}catch(NumberFormatException nfe) {
			System.out.println("숫자로 입력해야합니다.");
			
		}
		/*
		 *  실행 스택에서 일어난 일을 콘솔창에 출력하기
		 *  (자세한 예외 정보를 예외객체가 콘솔창에 출력하게 하기)
		 */		
	}
}
