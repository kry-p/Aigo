import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, K;
	static int[] arr;
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt, num= Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		arr = new int[100002];

		cnt = 0;

		if (N == K) {
			System.out.println(0);
			System.out.println(1);
		} else {
			bfs(N);
			System.out.println(num);
			System.out.println(cnt);
		}

	}

	static void bfs(int n) {
		queue.add(n);
		arr[n] = 1;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			
			// now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (num < arr[temp]) return;
			
			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = temp + 1;
				} else if (i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}

				if (next < 0 || next > 100000)
					continue;

				if (next == K) {
//                    System.out.println(arr[temp]+1);
					num = arr[temp];
					cnt++;

//					return;
				}
				
				//첫 방문, 방문했어도 시간이 같을 경우 
				if (arr[next] == 0 || arr[next] == arr[temp] + 1) { 
					queue.add(next);
					arr[next] = arr[temp] + 1;
				}
			}
		}
	}
}
