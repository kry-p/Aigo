package test09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T209_BOJ1058_친구 {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		// 입력
		for(int i = 0 ; i < N; i++)
		{
			String s = br.readLine();
			char[] arr = s.toCharArray();
			map[i] = arr;	
		}
		
		int[] count = new int[N];		
		
		visit = new boolean[N][N];
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'Y') {
					
					// 서로 친구
					if(visit[i][j] == false) {
						count[i]++;
						visit[i][j] = true;
					}
					
					// 친구의 친구
					for(int k = 0; k < N; k++) {
						if(map[j][k] == 'Y' && visit[i][k] == false && i != k) {
							count[i]++;
							visit[i][k] = true;
						}
					}
					
				}	
			}
		}
		
		Arrays.sort(count);
		System.out.println(count[N-1]);
	}
}

/*
5
NYNNN
YNYNN +1 +2 3
NYNYN +2 +2 4
NNYNY
NNNYN

4
*/
