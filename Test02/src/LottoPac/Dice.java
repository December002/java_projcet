package LottoPac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Dice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("몇개를 구매하실 건가요? :");
		int num=scan.nextInt();
		for(int i=0; i<num; i++) {
			System.out.println();
		}
	}
	
	public static void printLotto() {
		Random ran=new Random();
		Set<Integer> lottoSet=new HashSet<>();
		while(true) {
			int ranNum=ran.nextInt(45)+1;
			lottoSet.add(ranNum);
			if(lottoSet.size()<6) {
				break;
			}
		}
		List<Integer> lottoNums=new ArrayList<>(lottoSet);
		Collections.sort(lottoNums);
		for(int i=0; i<lottoNums.size(); i++) {
			int nums=lottoNums.get(i);
			System.out.println(nums);
			if(i != lottoNums.size()-1) {
				System.out.println(", ");
			}
		}
	}
}

