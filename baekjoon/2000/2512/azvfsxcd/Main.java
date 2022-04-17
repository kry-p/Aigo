package test09;

import java.util.Arrays;
import java.util.Scanner;

public class T218_BOJ2512_예산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += array[i] = sc.nextInt();
		}

		int budget = sc.nextInt();
		Arrays.sort(array);

		if (sum <= budget) {
			System.out.println(array[n - 1]);
		} else {
			int tmp = budget / n;
			int remain = n;
			for (int i = 0; i < n; i++) {
				if (array[i] <= tmp) {
					budget -= array[i];
				} else {
					remain = n - i;
					tmp = budget / remain;
					if (array[i] > tmp) {
						break;
					}
					i--;
				}
			}
			System.out.println(budget / remain);

		}
	}
}
