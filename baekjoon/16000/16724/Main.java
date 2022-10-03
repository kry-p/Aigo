package Algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16724_피리부는사나이 {

	static char map[][];
	static int visit[][];
	static int cnt = 1;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i] = s.toCharArray();
			}
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.err.print(visit[i][j] + " ");
//			}
//			System.err.println();
//		}
		
		System.out.println(cnt-1);
	}


	static int dfs(int row, int col) {
		if (visit[row][col] != 0) {
			if (visit[row][col] == cnt) {
				cnt++;
			}
			return visit[row][col];
		}
		
		int nextRow = row;
		int nextCol = col;
		
		visit[row][col] = cnt;
		
		if (map[row][col] == 'D') {
			nextRow += 1;
		}
		else if (map[row][col] == 'U') {
			nextRow -= 1;
		}
		else if (map[row][col] == 'L') {
			nextCol -= 1;
		}
		else if (map[row][col] == 'R') {
			nextCol += 1;
		}
		return visit[row][col] = dfs(nextRow, nextCol);
	}
}
