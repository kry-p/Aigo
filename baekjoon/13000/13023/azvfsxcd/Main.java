import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 관계 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}
		
		// 0번 친구부터 확인
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, 0);
			// 위와 같은 관계 발견 시
			if (cnt == 4)
				break;
		}

		if (cnt == 4)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void dfs(int my, int count) {

		cnt = Math.max(cnt, count);
		// 위와 같은 관계 발견 시
		if (cnt == 4)
			return;

		for (int frd : arr[my]) {
			if (visited[frd])
				continue;
			visited[frd] = true;
			dfs(frd, count + 1);
		}
		// 다른 경로에서도 확인할 수 있도록
		visited[my] = false;
	}

}
