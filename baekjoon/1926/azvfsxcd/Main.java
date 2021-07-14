import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt = 0, dsize;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int max=0;	

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1 && visited[i][j] == false) {
					cnt++;
					dsize = 1;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max=Math.max(max, map[i][j]);
			}
		}
		
		System.out.println(max);

	}

	private static void bfs(int i, int j) {
		visited[i][j]=true;
		queue.add(new Point(i, j));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx < N && ny < M && nx >= 0 && ny >= 0 && map[nx][ny] == 1 && visited[nx][ny] == false) {
					map[nx][ny]=++dsize;		// 이거 위치...
					visited[nx][ny] = true;
					max = Math.max(max, dsize);
					queue.add(new Point(nx, ny));

				}

			}

		}

	}
}
