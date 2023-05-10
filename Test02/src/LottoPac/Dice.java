package LottoPac;

import java.util.Random;
import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {
		Random random=new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("몇개를 구매하실 건가요? :");
			
		
		for(int i=0; i<6; i++) {
			System.out.print("["+random.nextInt(43)+"]");
			
		}
	}
}
