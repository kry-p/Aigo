import java.util.Arrays;
import java.util.Scanner;

public class main {
	static int N;
	static int[] arr, map;
	static int sum;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	
	arr = new int[N];
	map = new int[N];
	visited = new boolean[N+1];
	
	for(int i =0; i < N; i++) {
		arr[i] = sc.nextInt();
	}
	sum = 0;
	Arrays.sort(arr);
	
	dfs(0);
	
	System.out.println(max);
	
	}

	private static void dfs(int num) {
		if(num == N) {
			sum=0;
			for(int i=0; i < N-1; i++) {
				sum += Math.abs(map[i]-map[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			map[num]=arr[i];
			dfs(num+1);
			visited[i]=false;
		}
		
		
	}
}

	
