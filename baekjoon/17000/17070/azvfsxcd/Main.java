import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };
	static int cnt;
//	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
//		visited = new boolean[N+1][N+1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[0][1] = 1;
		dfs(0, 1, 2);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int k) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		
		
		if (k == 1) {					// 대각선일 경우 모든 방향
			if(x+1 < N && map[x+1][y]==0) {
				dfs(x+1,y,0);
			}
			if(y+1 < N && map[x][y+1]==0) {
				dfs(x,y+1,2);
			}
			if(x+1 < N && y+1 < N && map[x+1][y+1]==0) {
				if(!check(x,y)) {
					return;
				}
				dfs(x+1,y+1,1); 
			}
			
//			for (int d = 0; d < 3; d++) { // 밑, 대각선, 오른쪽
//				int nx = x + dx[d];
//				int ny = y + dy[d];
//				
//				if(d==1) {
//					if(!check(x,y)) {
//						return;
//					}
//				}
//				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
//					map[nx][ny] = 1;
//					dfs(nx, ny, d);
//					map[nx][ny] = 0;
//				}
//			}
		} else if(k==2) {
			if(y+1 < N && map[x][y+1]==0) {
				dfs(x,y+1,2);
			}
			if(x+1 < N && y+1 < N && map[x+1][y+1]==0) {
				if(!check(x,y)) {
					return;
				}
				dfs(x+1,y+1,1); 
			}
			
//			int a = k;
//			while(a>0) {
//				int nx = x + dx[a];
//				int ny = y + dy[a];
//				
//				if(a==1) {
//					if(!check(x,y)) {
//						return;
//					}
//				}
//
//				if (nx >= 0 && ny >= 0 && nx < N && ny <N && map[nx][ny] == 0) {
//					map[nx][ny] = 1;
//					dfs(nx, ny, a);
//					map[nx][ny] = 0;
//				}
//				a--;
//			}
		} else {
			if(x+1 < N && map[x+1][y]==0) {
				dfs(x+1,y,0);
			}
			if(x+1 < N && y+1 < N && map[x+1][y+1]==0) {
				if(!check(x,y)) {
					return;
				}
				dfs(x+1,y+1,1); 
			}
//			for (int d = 0; d < 2; d++) { // 밑, 대각선
//				int nx = x + dx[d];
//				int ny = y + dy[d];
//				
//				if(d==1) {
//					if(!check(x,y)) {
//						return;
//					}
//				}
//
//				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
//					map[nx][ny] = 1;
//					dfs(nx, ny, d);
//					map[nx][ny] = 0;
//				}
//			}
		}

	}

	private static boolean check(int x, int y) {
		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N
					&& map[nx][ny]!=0) {
				return false;
			}
		}
		return true;
		
	}
}

