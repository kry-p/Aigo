import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T208_BOJ1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(k != l) {
			k = k/2 + k % 2;
			l = l/2 + l % 2;
			cnt++;
		}
		System.out.println(cnt);
	}
}