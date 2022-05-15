package algoStudy01;

import java.util.Scanner;

public class BOJ2502_떡먹는호랑이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();		// 넘어온날
		int k = sc.nextInt();		// 떡 개수 
		
		int dp[] = new int[100001];

		for(int a = 1; a < k; a++) {		// 이거 k로 바꾸고
			for(int b = 1; b < k; b++) {
				dp[1] = a;
				dp[2] = b;
				
				for(int i = 3; i <= d; i++) {		// 이거 d로 바꾸고
					dp[i] = dp[i-1] + dp[i-2];
					
					if(dp[d] == k) {
						System.out.println(dp[1]);
						System.out.print(dp[2]);
						System.exit(0);				// 강종 추가
					}
				}
			}
			
			
		}

		
/*
 
단 어떤 경우에는 답이 되는 A, B가 하나 이상일 때도 있는데 이 경우에는 그 중 하나만 구해서 출력하면 된다.
 
a , b

1	2	3		4		5		6		7		8		9
a	b	a+b		a+2b	2a+3b	3a5b	5a8b	8a11b	13a19b

10
21

*/
	}
}
