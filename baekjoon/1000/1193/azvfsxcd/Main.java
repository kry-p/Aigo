import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n = 1;
		int m = 1;
		int line = 0;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 밑의 줄 찾기에서 1, 2 의 줄을 못찾음...
		if(N == 1) {
			System.out.println("1/1");
		}
		if(N == 2) {
			System.out.println("1/2");
		}
		
		// 줄 찾기용
		int s=0;
		for(int i=0; i<N; i++) {
			s += i;
			if(s>=N) {
				line = i;
				s-=i;	// line의 첫자리 찾으려고
				break;
			}
		}
//		System.out.println(s);
//		System.out.println(line);
		if(line % 2 == 0) {		// 짝수
			m = line;
			cnt = s + 1;
			for(int i =0; i<line; i++) {
				if(cnt == N) {
					System.out.println(n+"/"+m);
					break;
				}
				n++;
				m--;
				cnt++;
			}
		} else {
			n = line;
			cnt = s + 1;
			for(int i =0; i<line; i++) {
				if(cnt == N) {
					System.out.println(n+"/"+m);
					break;
				}
				n--;
				m++;
				cnt++;
			}
		}
	}
}
