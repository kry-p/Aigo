import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, max=Integer.MIN_VALUE;
	static List<Integer>[] list;
	static boolean[] visited = new boolean[10001];
	static int[] ans = new int[10001];

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		ans = new int[N+1];
		list = new ArrayList[N + 1]; 
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		String[] inputs = new String[2];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());	
			inputs[0] = st.nextToken();
			inputs[1] = st.nextToken();
			list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
		}

		for(int i = 1; i<=N; i++) {
			visited = new boolean[N+1]; 		// 계속 초기화
			visited[i]=true;
			dfs(i);
		}
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, ans[i]);
		}
		
		for(int i=1; i<=N; i++) {
			if(max == ans[i]) {
				System.out.print(i);
				if(i!=N) {
					System.out.print(" ");
				}
			}
		}
		
	}


	private static void dfs(int i) {
		for(int hack : list[i]) {
			if(visited[hack] == false) {
				ans[hack]++;
				visited[hack] = true;
				dfs(hack);
			}
		}
	}
}
