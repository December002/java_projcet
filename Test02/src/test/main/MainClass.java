package test.main;

import test.mypac.Weapon;

public class MainClass {
	static class SeaWeapon extends Weapon{
		@Override
		public void attack() {
			System.out.println("해상 공격을 해요!");
		}
	}
	public static void main(String[] args) {
		Weapon w1 = new SeaWeapon();
		w1.prepare();
		w1.attack();
		
		
		class SpaceWeapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("우주 공격을 해요!");
			}
		}
		
		Weapon w2 = new SpaceWeapon();
		w2.prepare();
		w2.attack();
	}
}
