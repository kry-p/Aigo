import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] dp = new boolean[101][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 		// 곡의 개수
		int S = Integer.parseInt(st.nextToken()); 		// 시작 볼륨
		int M = Integer.parseInt(st.nextToken()); 		// 최대 볼륨
		int[] vol = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		} 
		
		dp[0][S] = true;
		for (int idx = 1; idx <= N; idx++) {
			for (int i = 0; i <= M; i++) {
				if (!dp[idx - 1][i]) {
					continue;
				}
				if (i - vol[idx] >= 0) {
					dp[idx][i - vol[idx]] = true;
				} //  P+V[i] P-V[i] 
				if (i + vol[idx] <= M) {
					dp[idx][i + vol[idx]] = true;
				}
			}
		}
		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
