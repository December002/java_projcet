package test.main;

public class MainTest3 {
	public static void main(String[] args) {
		System.out.println("메소드 시작");
		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("메소드 종료");
	}
}
