package test09;

import java.util.Scanner;

public class T217_BOJ2133_타일채우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[31];
		
		// 홀수는 어차피 안됨
		dp[0] = 1;
		dp[2] = 3;
		
		for(int i = 4; i <= N; i++) {
			// 이전거 반복
			dp[i] = dp[i - 2] * 3;
			
			// 새로 생기는 방법
			for(int j = 4; j<=i; j+=2) {
				dp[i] += dp[i-j] * 2;
			}
		}
	
		
		System.out.println(dp[N]);
		
	}
}
