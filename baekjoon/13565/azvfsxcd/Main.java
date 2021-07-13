import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		for(int j = 0 ; j < M; j++) {
			if(map[0][j]==0) {
				bfs(0, j);			
			}
		}
		
		boolean ck = false;
		for (int j = 0; j < M; j++) {
			if (map[N - 1][j] == 2) {
				ck=true;
			}
		}
		System.out.println(ck? "YES" : "NO");

	}

	private static void bfs(int i, int j) {
		queue.add(new Point(i, j));
		map[i][j]=2;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx<N && ny<M && nx>=0 && ny>=0 && map[nx][ny]==0) {
					map[nx][ny]=2;
					queue.add(new Point(nx, ny));
					
				}
				
			}
			
		}

	}
}
