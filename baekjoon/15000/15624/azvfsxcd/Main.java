package Algo01;

import java.util.Scanner;

public class BOJ15624_피보나치7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int N = sc.nextInt();
		
		int[] dp = new int[1000001];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
 
		System.out.println(dp[N]);
	}
}

// 0 1 1 2 3 5 8 13 21 ...... (N) = (N-1) + (N-2)