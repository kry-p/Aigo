import java.util.Scanner;

public class T205_BOJ19539_사과나무 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		boolean flag = false;
		int sum = 0;
		int cnt = 0;		// 홀수 개수

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i]%2==1) {		
				cnt++;
			}
		}
		if (sum % 3 == 0) {
			int a = sum / 3; // 2의 개수
//			int b = sum - (2 * a); // 1의 개수? b랑 같거나 3배수 차이여야함
			if(cnt<=a) {
				flag =true;
			}
//			if (a == b) {
//				flag = true;
//			} else if ((a - b) % 3 == 0) {
//				flag = true;
//			}

		} else {
			flag = false;
		}

		System.out.println(flag ? "YES" : "NO");
	}
}
