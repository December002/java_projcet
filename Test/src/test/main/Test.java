package test.main;

public class Test {
	public String name;
	public String age;
	public String belong;
	
	public void classroom() {
		System.out.println(age+ " "+ name+ " " + belong);
		
		
	}

	


	@Override
	public String toString() {
		return "Test [name=" + name + ", age=" + age + ", belong=" + belong + "]";
	}


	public void goSchool(){
		System.out.println("학교 다녀오겠습니다");
	}
	

	
	public static void main(String[] args) {
		Test school = new Test();
		
		school.age="나이";
		school.name="이름";
		school.belong="소속";
			
		school.classroom();
		school.goSchool();
		System.out.println(school.toString());
	}

}
