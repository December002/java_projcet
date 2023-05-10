package test.main;

import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		Weapon w1 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무나 공격하자!");
			}
		};
		useWeapon(w1);
		
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("어디로 공격하지?");
			}
		});
	}
	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	};
}
