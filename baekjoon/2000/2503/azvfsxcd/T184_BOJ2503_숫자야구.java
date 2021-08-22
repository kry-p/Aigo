package test08;

import java.util.Scanner;

public class T184_BOJ2503_숫자야구 {
	private static int N, cnt = 0;
	private static boolean num[] = new boolean[988]; 		// 987 위로는 없으니까
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int n = 0; n < N; n++) {
			check(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		for(int i = 123; i < 988; i++) {
			if(!num[i]) {
//				System.out.println(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void check(int number, int strike, int ball) {
		int a = number/100, b = number%100/10, c = number%10;		// 100자리, 10자리, 1자리
		
		for(int i = 123; i < 988; i++) {
			if(num[i]) continue;
			int a2 = i/100, b2 = i%100/10, c2 = i%10, strike2 = 0, ball2 = 0;
			// 0이 나올수 없고 서로 다른 숫자로만 구성
			if(a2 == 0 || b2 == 0 || c2 == 0 || a2 == b2 || b2 == c2 || a2 == c2) { 
				num[i] = true;
				continue; 
				}
			if(a == a2) strike2++;
			if(b == b2) strike2++;
			if(c == c2) strike2++;
			if(a == b2 || a == c2) ball2++;
			if(b == a2 || b == c2) ball2++;
			if(c == b2 || c == a2) ball2++;
			
			if(strike != strike2 || ball != ball2) {
				num[i] = true;
			}
		}
	}
	
	
}
