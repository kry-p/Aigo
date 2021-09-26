import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Integer[] arr = new Integer[4];
		int cnt = 0;
		boolean[] visited = new boolean[1002];
		int N = sc.nextInt();
		int sum = 0;
		for(int i = 0; i <= N; i++) {
//			arr[0]=i;
			sum+=(50*i);
			for(int j = 0; j <= N-i; j++) {
//				arr[1]=j;
				sum+=(10*j);
				for(int k = 0; k <= N-i-j; k++) {
//					arr[2]=k;
//					arr[3]= N-i-j-k;
					sum+=(5*k+N-i-j-k);
					if(!visited[sum]) {
						cnt++;						
					}
					visited[sum]=true;
					sum-=(5*k+N-i-j-k);
				}
				sum-=(10*j);
			}
			sum-=(50*i);
		}
		
		System.out.println(cnt);
	}
}
