package algoStudy01;

import java.util.Scanner;

public class BOJ10991_별찍기16 {
	public static void main(String[] args) {
		int num = new Scanner(System.in).nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = i; j < num-1; j++) {
				System.out.print(" ");
			}
			for(int z = 0; z <= i; z++) {
				System.out.print("*");
				if(z != i) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
