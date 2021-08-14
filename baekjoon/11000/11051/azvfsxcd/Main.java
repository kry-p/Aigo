import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		K  = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][N+1];


//		1
//		1 1
//		1 2 1
//		1 3 3 1
//		1 4 6 4 1
//		1 5 10 10 5 1
//		1 6 15 20 15 6 1
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N; j++) {
				if(j==0 || i==j) {
					dp[i][j]=1;
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
				}
			}
		}
		
		System.out.println(dp[N][K]);

	}


}
