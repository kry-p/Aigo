import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		visited = new boolean[7];

		if (M == 1) {
			test1(0);
		} else if (M == 2) {
			test2(0,1);
		} else {
			test3(0);
		}
	}

	private static void test1(int num) {
		if (num == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]);
				if (i != N - 1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}

			}
			return;
		}

		for (int i = 1; i <= 6; i++) {
			arr[num] = i;
			test1(num + 1);
		}

	}

	private static void test2(int num, int start) {
		if (num == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]);
				if (i != N - 1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}

			}
			return;
		}

		for (int i = start; i <= 6; i++) {
			arr[num] = i;
			test2(num + 1, i);
		}

	}

	private static void test3(int num) {
		if (num == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]);
				if (i != N - 1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}

			}
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (visited[i] == true)
				continue;
			arr[num] = i;
			visited[i] = true;
			test3(num + 1);
			visited[i] = false;
		}

	}
}
