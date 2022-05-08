package algoStudy01;

import java.util.Scanner;

public class BOJ2980_도로와신호등 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		// 현재위치, 경과시간
		int p = 0;
		int answer = 0;
		
		
		for(int i = 0; i < N; i++) {
			int d = sc.nextInt();
			int r = sc.nextInt();
			int g = sc.nextInt();
			
			answer += (d - p);
		    p = d;
		    if (answer % (r+g) <= r) {
		    	answer += (r - (answer%(r+g)));
		    }
		}
		answer += (L-p);
		
		System.out.println(answer);
		
	}
}
