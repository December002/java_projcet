package test.main;

import test.apl.Apl;

public class Main {
	public static void main(String[] args) {
		Apl apl1 = new Apl();
		
		apl1.cls="economi";
		apl1.cost = 1000;
		
		apl1.drive();
		
		Apl apl2 = new Apl();
		
		apl2.cls = "business";
		apl2.cost = 2000;
		
		Apl apl3 = new Apl();
		
		apl3.cls = "first";
		apl3.cost= 3000;
		
		boolean result1 = apl1.cls == apl2.cls ;
				
	}
}
