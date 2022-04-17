package test09;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T219_BOJ17086_아기상어2 {
	static int N, M, cnt = 0;
	static int[][] map;
	static Shark shark;
	
	static class Shark {
		int r, c, cnt;

		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Shark(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		ArrayList<Point> shark = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
					shark.add(new Point(i, j));
				}
			}
		}
		for(int i = 0, size = shark.size(); i < size; i++) {
			Point cur = shark.get(i);
			bfs(cur.x, cur.y);
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != -1 && res < map[i][j]) {
					res = map[i][j];
				}
			}
		}
		System.out.println(res);
	}
	

	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};


	private static void bfs(int x, int y) {
		Queue<Shark> queue = new LinkedList<>();
		queue.add(new Shark(x, y, 0));
		
		while (!queue.isEmpty()) {
			int size = queue.size(); // 움직이는 시간이 같은 얘들의 크기 

			for (int i = 0; i < size; i++) {
				Shark p = queue.poll();

				for (int d = 0; d < 8; d++) {
					int nr = p.r + dx[d];
					int nc = p.c + dy[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == -1 ) continue;
					if(map[nr][nc] == 0 || (map[nr][nc] != 0 && p.cnt+1 < map[nr][nc])) {
						map[nr][nc] = p.cnt+1;
						queue.offer(new Shark(nr, nc, p.cnt+1));				
					}
				}
			}
		}
	}

}
