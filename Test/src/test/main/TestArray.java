package test.main;

import java.util.Random;

public class TestArray {
	public static void main(String[] args) {

		
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
		
			
 		
		Random ran=new Random();
		
		int [] nums = new int[3];

		for(int i=0; i<3; i++) {
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum;
			System.out.print(items[ranNum]);
			if(i<2) {
				System.out.print(" | ");
			}
		}
		
		System.out.println();
		
		if(nums[0] == nums[1] && nums[1] == nums [2]) {
			System.out.println("당첨됐습니다!");
		}else {
			System.out.println("꽝");
		}
		
	}
}
