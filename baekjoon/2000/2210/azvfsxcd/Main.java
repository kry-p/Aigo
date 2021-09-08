import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
//	static int[][] s;
//	static int cnt;
	 static HashSet<String> list;
	 static int[] dx = { 0, 1, 0, -1 };
	 static	int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for(int i =0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new HashSet<String>();
		String s = new String();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, s);
			}
		}
		
		System.out.println(list.size());
		
		
	}
	public static void dfs(int i, int j, int n, String s) {
		if(n==6) {
			list.add(s);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx>=0 && ny>=0 && nx<5 && ny<5) {
				dfs(nx, ny, n+1, s+ arr[i][j]);
			}
			
		}
		
	}
}
