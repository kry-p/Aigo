package Algo01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1417_국회의원선거 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();	// 다솜
        
        if (n == 1) {			// 없으면 런타임 에러나옴
        	System.out.println(0);
        	return;
        }
        
        int[] arr = new int[n-1];
        
        for (int i = 0; i < n-1; i++) {
        	arr[i] = sc.nextInt();
        }
        
        int cnt = 0;
        while (true) {
            Arrays.sort(arr);	

            if (arr[n-2] < a) break;
            cnt++;
            arr[n-2]--;
            a++;
        }
        System.out.println(cnt);
	}
}
