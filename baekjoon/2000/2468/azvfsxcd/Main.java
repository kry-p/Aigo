import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		
		int max = 1;	// 숫자가 전부 같을 경우 1이 나옴 하......
		int max_input = 0;
		int min_input = 102;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]= sc.nextInt();
				max_input = Math.max(map[i][j], max_input);
				min_input = Math.min(map[i][j], min_input);
			}
		}
		
		for(int k = min_input ; k < max_input; k++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]<=k) {
						visited[i][j]=true;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}			
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		
	}
	static void bfs(int x, int y) {	
		queue.add(new Point(x,y));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			visited[p.x][p.y] = true;
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
					queue.add(new Point(nx, ny));
					visited[nx][ny]=true;
				}
			}
		}
		cnt++;
	}
}
