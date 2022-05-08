package algoStudy01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합 {
	static int N;
	static int S;
	static boolean is[];
	static int[] numbers;
	static int[] arr;
	static int cnt1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		is = new boolean[N+1];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N;i++) {
			numbers = new int[i];
			test(0, i, 1);			
		}
		System.out.println(cnt1);
	}

	static void test(int cnt, int r, int start) {
		if(cnt==r) {
			int sum=0;
			for(int i=0;i<numbers.length;i++) {
				sum += numbers[i];
			}
			if(sum==S) cnt1++;
			return;
		}
		
		for(int i=start; i<=N;i++) {
			if(is[i]) continue;
			
			numbers[cnt]=arr[i];
			is[i]=true;
			test(cnt+1, r, i);
			is[i]=false;
		}
	}
}
