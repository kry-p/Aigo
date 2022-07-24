import java.util.Scanner;

public class Main {
	static int dx[] = { 0, 0, 1, -1};
	static int dy[] = { 1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 2 * N * M;
		int arr[][] = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
						if(arr[nx][ny] < arr[i][j]) {
							cnt += (arr[i][j] - arr[nx][ny]);
						} 
					} else {
						cnt += arr[i][j];
					}
					
				}
			}
		}
		
		
		System.out.println(cnt);
		
	}
}
