import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
    static int M;
    static int[][] map;
    static int cnt;
    static boolean[][][] visit;
    static Queue<Info> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};	
	static int[] dy = {-1, 0, 1, 0};

	static class Info{
        int x, y, dir;
        public Info(int y, int x, int dir){
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][4];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){ 
                	for (int dir = 0; dir < 4; dir++) {
						visit[i][j][dir] = true;
						q.add(new Info(i, j, dir));
					}
                }
            }
        }
        
        bfs();
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int dir = 0; dir < 4; dir++) {
					if(visit[i][j][dir]) {
						cnt++;
						break;
					}
				}
			}
		}
        
		System.out.println(cnt);
        
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];
			
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			if(visit[ny][nx][cur.dir]) continue;
			
			visit[ny][nx][cur.dir] = true;
			
			switch(map[ny][nx]) {
			case 1 :
				if(cur.dir == 1 || cur.dir == 3) continue;
				break;
			case 2 :
				if(cur.dir == 0 || cur.dir == 2) continue;
				break;
			case 3 :
				if(cur.dir == 0) cur.dir = 1;
				else if(cur.dir == 1) cur.dir = 0;
				else if(cur.dir == 2) cur.dir = 3;
				else if(cur.dir == 3) cur.dir = 2;
				break;
			case 4 :
				if(cur.dir == 0) cur.dir = 3;
				else if(cur.dir == 1) cur.dir = 2;
				else if(cur.dir == 2) cur.dir = 1;
				else if(cur.dir == 3) cur.dir = 0;
				break;
			}
			
			q.add(new Info(ny, nx, cur.dir));
		}
	}
	
}
