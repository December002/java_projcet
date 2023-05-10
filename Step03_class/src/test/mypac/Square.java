package test.mypac;

public class Square {
	//필드
	public int width;
	public int height;
	//메소드
	public void area(){
		//면적 계산하기
		int result=this.width * this.height;
		//콘솔창에 면적 출력하기
		System.out.println("사각형의넓이:"+result);
	}
}
