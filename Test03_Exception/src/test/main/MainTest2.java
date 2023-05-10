package test.main;

import java.util.Scanner;

public class MainTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("나눌 수 입력 :");
		String strNum1=scan.nextLine();
		System.out.print("나눠지는 수 입력 :");
		String strNum2=scan.nextLine();
		
		try {
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result1 = num1/num2;
		int result2 = num1%num2;
		
		System.out.println("나눈값은"+result1+" 입니다.");
		System.out.println("나머지 값은"+result2+" 입니다.");
		}catch(NumberFormatException nfe) {
			System.out.println("숫자로만 입력해야 합니다.");
		}catch(ArithmeticException ae) {
			System.out.println("나눠지는 수에 0을 넣을 수 없습니다.");
		}finally {
			System.out.println("계산 끝!");
		}
	}
}
