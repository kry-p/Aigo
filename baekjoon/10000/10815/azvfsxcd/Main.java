package Algo01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10815_숫자카드 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr = new int[N];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        
        Arrays.sort(nArr);
        
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int m = sc.nextInt();
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int n = nArr[mid];
                if (n == m) {
                    sb.append(1 + " ");
                    break;
                }
                if (n > m) { //지금 상근이 카드보다 더 작은거 찾아야함
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                if (left > right) {
                    sb.append(0 + " ");
                    break;
                }
            }
        }
        System.out.println(sb.toString());

	}
	
	

}
