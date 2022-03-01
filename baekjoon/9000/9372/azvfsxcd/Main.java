import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] move;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			move = new int[N+1][N+1];
			visited = new boolean[N+1];
			cnt = 0;
			for(int i = 0; i < M; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				move[x][y] = 1;
				move[y][x] = 1;
				
			}	// i 
			
			bfs();
			
			System.out.println(cnt-1);
		
		} // tc
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			cnt++;
			int p = queue.poll();
			for(int i = 1; i <= N; i++) {
				if(move[p][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		
	}
}
