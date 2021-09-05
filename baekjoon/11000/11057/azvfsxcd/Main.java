import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][10];
		
		// 1 1 1 1 1 1 1 1 1 1 
		// 10 9 8 7 6 5 4 3 2 1
		// 55 45 36 28 21 15 10 6 3 1
		// 220 ..
		
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][0] % 10007); 
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		
//		int[] dp = new int[1002];
//		
//		dp[0] = 0;
//		dp[1] = 10;
//		
//		int[] arr = new int[10];
//		
//		for(int i = 0 ; i< 10; i++) {
//			arr[i] = 1;
//		}	
//		
//		for(int i = 1; i < 1001; i++) {
//			int temp = arr[0];
//			int temp2 = 0;
////			int size = (int) Math.log10(i);
//			arr[0] = dp[i]%10007;
//			for(int j = 1; j < 10; j++) {
//				if(j==1) {
//					temp2 = arr[j];
//					arr[j] = (arr[j-1] - temp);
//				} else {
//					if(j%2==0) {
//						temp = arr[j];
//						arr[j] = (arr[j-1] - temp2);						
//					} else {
//						temp2 = arr[j];
//						arr[j] = (arr[j-1] - temp);						
//					}
//				}
//			}
//			int sum = 0;
//			for(int j =0 ; j < 10; j++) {
//				sum += arr[j];
//			}
//			dp[i+1] += sum%10007;
//		}
//		
//		System.out.println(dp[N]);
//		
//		
//		
//	}
}
