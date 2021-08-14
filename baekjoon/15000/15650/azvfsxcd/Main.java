import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int N;
	static int M;
	static boolean[] B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		N=n;
		M=m;
		numbers = new int[M];
		B = new boolean[N+1];
		
		test(0,1);
	}
	
	
	static void test(int cnt, int start) {
		if (cnt == M){
			for(int i =0; i <numbers.length;i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<=N; i++) {
			if(B[i]) continue;
			
			numbers[cnt] = i;
			B[i]=true;
			test(cnt+1, i);
			B[i]=false;
		}
		
		
	}
}
