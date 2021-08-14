import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt=0;
		visited = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m; i++) {
			visited[Integer.parseInt(st.nextToken())] = true;
		}
		
		dfs(0);
		
		System.out.println(cnt);
		
	}
	
	private static void dfs(int i) {
		if(i == n) {
			if(ck(visited)) cnt++;
			return;
		}
		
		for(int j = 0; j < 10;j++) {
			if(visited[j]) {
				visited[j]=false;
				dfs(i+1);
				visited[j] = true;
				continue;
			}
			dfs(i+1);
		}
		
	}

	static boolean ck (boolean[] visit) {			// 비밀 번호 다 썼는지 체크, false : 다 못씀, true : 다 씀
		for(int i = 0; i < 10; i++) {
			if(visit[i]==true) {
				return false;						
			}
		}
		return true;
	}
}
