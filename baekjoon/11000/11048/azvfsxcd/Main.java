import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.LinkedList;
//import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp;
//	static Queue<Point> queue = new LinkedList<>();

//	static int[] dx = { 0, 1, 1 };
//	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0);

		System.out.println(dp[N - 1][M - 1]);

	}

	private static void bfs(int x, int y) {
		dp[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(0<i && 0<j)	dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j], dp[i][j-1]))+ map[i][j];
				else if(i == 0 && 0 < j) dp[i][j] = dp[i][j-1] + map[i][j];
				else if(j == 0 && 0 < i) dp[i][j] = dp[i-1][j] + map[i][j];
			}
		}
		
				



	}
}
