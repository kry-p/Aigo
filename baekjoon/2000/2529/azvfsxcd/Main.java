import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static char[] map;
	static int[] arr;
	static int A;
	static boolean[] visited = new boolean[10];
	static int[] max;
	static int[] min;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		map = new char[k];
		arr = new int[k + 1];
		
		max = new int[k + 1];
		min = new int[k + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			map[i] = st.nextToken().charAt(0);
		}
		cnt = 0;

		dfs(0);

		for (int j = 0; j < k + 1; j++) {
			System.out.print(max[j]);
		}
		System.out.println();
		for (int j = 0; j < k + 1; j++) {
			System.out.print(min[j]);
		}

	}

	private static void dfs(int i) {
		if (i == k + 1) {
			if(cnt==0) {
				for (int j = 0; j < k + 1; j++) {
					min[j]=arr[j];
				}
				cnt++;
			}
			for (int j = 0; j < k + 1; j++) {
				max[j]=arr[j];
			}

			return;
		}

		for (int j = 0; j < 10; j++) {
			if (visited[j])
				continue;
			if (i == 0) {
				for (int l = 0; l < k + 1; l++) {
					arr[l] = 0;
				}
				arr[i] = j;
				visited[j] = true;
				dfs(i + 1);
				visited[j] = false;
			} else {
				if (map[i - 1] == '<') {
					if (arr[i - 1] < j) {
						arr[i] = j;
						visited[j] = true;
						dfs(i + 1);
						visited[j] = false;
					} else {
						continue;
					}
				} else {
					if (arr[i - 1] > j) {
						arr[i] = j;
						visited[j] = true;
						dfs(i + 1);
						visited[j] = false;
					} else {
						continue;
					}
				}
			}

		}

	}



}
