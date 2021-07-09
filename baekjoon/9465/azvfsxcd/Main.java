import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[1][i] = Integer.parseInt(st.nextToken());
			}

			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			

			for (int i = 1; i < n; i++) {
//				dp[0][i] = Math.max(dp[0][i - 1], arr[0][i]);
				if(i>=1) {
					dp[0][i] = Math.max(dp[0][i - 1], arr[0][i]+dp[1][i-1]); //7시방향 숫자도 생각해야했음
				}
//				dp[1][i] = Math.max(dp[0][i], arr[1][i]);
				if(i>=1) {
					dp[1][i] = Math.max(arr[1][i]+dp[0][i-1], dp[1][i-1]); //1시방향
				}
			}

			int max = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, dp[i][j]);
				}
			}

			System.out.println(max);

		} // tc
	}
}
