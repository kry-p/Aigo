import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[][] dpMax = new int[3][N];
		int[][] dpMin = new int[3][N];
		
		// 입력
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < 3; i++) {
				int a = sc.nextInt();
				dpMax[i][j] = a;
				dpMin[i][j] = a;
			}
		}
		
		// 구현
		for(int i = 1; i < N; i++) {
			dpMax[0][i] = dpMax[0][i] + Math.max(dpMax[0][i-1], dpMax[1][i-1]);
			dpMax[1][i] = dpMax[1][i] + Math.max(Math.max(dpMax[0][i-1], dpMax[1][i-1]), dpMax[2][i-1]);
			dpMax[2][i] = dpMax[2][i] + Math.max(dpMax[1][i-1], dpMax[2][i-1]);
			
			dpMin[0][i] = dpMin[0][i] + Math.min(dpMin[0][i-1], dpMin[1][i-1]);
			dpMin[1][i] = dpMin[1][i] + Math.min(Math.min(dpMin[0][i-1], dpMin[1][i-1]), dpMin[2][i-1]);
			dpMin[2][i] = dpMin[2][i] + Math.min(dpMin[1][i-1], dpMin[2][i-1]);
			
		}
		
		max = Math.max(Math.max(dpMax[0][N-1], dpMax[1][N-1]), dpMax[2][N-1]);
		min = Math.min(Math.min(dpMin[0][N-1], dpMin[1][N-1]), dpMin[2][N-1]);
		
		System.out.println(max + " " + min);
	}
}
