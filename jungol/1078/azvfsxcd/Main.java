import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max= Integer.MIN_VALUE;
	static int[][] arr;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1][N+1];
		map = new int[M+1][N+1];
		visited = new boolean[M+1][N+1];
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			char[] chs = str.toCharArray();
			for(int j = 0; j < chs.length; j++) {
				arr[i][j] = chs[j]-'0';
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		bfs(x-1, y-1);			

		System.out.println(max);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1 && map[i][j]==0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
	}

	
	private static void bfs(int x, int y) {
		queue.add(new Point(y, x));
		visited[y][x]=true;
		map[y][x]=3;
		max = Math.max(map[y][x], max);
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();	
			
			
			for (int d = 0; d < 4; d++) {
				int nx = p.y + dx[d];
				int ny = p.x + dy[d];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && visited[ny][nx]==false && arr[ny][nx]==1) {
					map[ny][nx] = map[p.x][p.y]+1;
					visited[ny][nx]=true;
					max = Math.max(map[ny][nx], max);
					queue.add(new Point(ny, nx));
				}
			}
			
			
		}
		
	}
}
