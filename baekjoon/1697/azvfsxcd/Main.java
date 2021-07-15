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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[100002];
		
		if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
		
	}

	static void bfs(int n) {
        queue.add(n);
        arr[n] = 0;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(arr[temp]+1);
                    return;
                }

                if (next >= 0 && next < 100002 && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[temp] + 1;
                }
            }
        }
    }
}

	
	
	/*
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[100002];
		
		int a=0;
		// 동생이 뒤에 있을 때
		for(int i = N; i>=0; i--) {	
			arr[i]=a++;
		}
		a=0;
		for(int i = N; i <= K+1; i++) {
			arr[i]=a++;
		}
		
		if(K*2<100001) {
			for(int i = N; i <= K*2; i++) {
				if(arr[i]>arr[i/2]+1 && i%2==0) {
					arr[i]=arr[i/2]+1;
				}			
			}
			for(int i = N; i <= K*2; i++) {
				if(arr[i]>arr[i-1]+1) {
					arr[i]=arr[i-1]+1;
				}
			}
			for(int i = N; i <= K*2; i++) {
				if(arr[i]>arr[i+1]+1) {
					arr[i]=arr[i+1]+1;
				}
			}
		}
		else {
			for(int i = N; i < 100002; i++) {
				if(arr[i]>arr[i/2]+1 && i%2==0) {
					arr[i]=arr[i/2]+1;
				}			
			}
			for(int i = N; i < 100002; i++) {
				if(arr[i]>arr[i-1]+1) {
					arr[i]=arr[i-1]+1;
				}
			}
			for(int i = N; i < 100001; i++) {
				if(arr[i]>arr[i+1]+1) {
					arr[i]=arr[i+1]+1;
				}
			}
			
		}
		
		System.out.println(arr[K]);
		
	}

}
*/
