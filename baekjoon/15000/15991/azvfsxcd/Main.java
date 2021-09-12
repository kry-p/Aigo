import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[1000001];
		dp[0] = 1;
		dp[1] = 1;				// 1
		dp[2] = 2;				// 1,1  2
		dp[3] = 2;				// 1,1,1  												1,2(대칭 아님)
		dp[4] = 3;				// 1,1,1,1  1,2,1  2,2  								1,3(대칭 아님)
		dp[5] = 3; 				// 1,1,1,1,1  1,3,1  2,1,2        						1,1,1,2(대칭 아님)  2,3(대칭 아님)
		dp[6] = 6;				// 1,~~,1,1  1,1,2,1,1  1,2,2,1(dp4)  2,1,1,2  2,2,2(dp2)  3,3		1,1,1,3(대칭 아님)  1,2,3(대칭 아님)      
		dp[7] = 6; 				// 1,~~1,1   1,1,3,1,1  1,2,1,2,1(dp5)  2,3,2  3,1,3
		/*
		 * 		1+*+1		n-2
		 * 		2+*+2		n-4
		 * 		3+*+3		n-6
		 *
		 */
		for(int j = 7; j < 1000001; j++) {
			dp[j]= (dp[j-2]+dp[j-4]+dp[j-6])%1000000009;
		}
		for(int i =0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	
	}
}
