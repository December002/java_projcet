package test.mypac;

public abstract class Weapon {
	public void prepare() {
		System.out.println("공격을 준비합니다");
	}
	public abstract void attack();
}
