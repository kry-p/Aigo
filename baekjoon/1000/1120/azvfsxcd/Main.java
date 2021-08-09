import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String st1 = st.nextToken();
		String st2 = st.nextToken();

		int min = Integer.MAX_VALUE;

		char[] arr1 = st1.toCharArray();
		char[] arr2 = st2.toCharArray();

		char[] map = new char[arr2.length]; // 비교용

		int len = arr2.length - arr1.length;

		for (int i = 0; i < arr2.length; i++) {
			map[i] = arr2[i];
		}

		for (int i = 0; i < arr1.length; i++) {
			map[i] = arr1[i];
		}

		for (int i = 0; i <= len; i++) {
			int a = 0;
			for (int j = i; j < arr1.length+i; j++) {
				if (map[j] != arr2[j]) {
					a++;
				}
			}
			for (int k = arr2.length - 1; k > 0; k--) { // 한칸씩 이동
				map[k] = map[k - 1];
			}
			map[i] = arr2[i];
			min = Math.min(min, a);
		}

		System.out.println(min);
	}
}

