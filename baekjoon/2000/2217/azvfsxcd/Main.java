package test09;

import java.util.Arrays;
import java.util.Scanner;

public class T211_BOJ2217_로프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		// 입력
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		// 사용할 줄의 개수??
		for(int i = 0; i<arr.length; i++) {
//			System.out.println(arr[i]*(N-i));
			cnt = Math.max(cnt, arr[i]*(N-i));
		}
		System.out.println(cnt);
	}
}
