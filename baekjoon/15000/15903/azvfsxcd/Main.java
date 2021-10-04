import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		
		for(int i = 0; i<M; i++) {
			Arrays.sort(arr);
			arr[0]=arr[0]+arr[1];
			arr[1]=arr[0];
		}
		
		for(int i =0; i<N; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
		
	}
}
