import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			dp[i]= Integer.parseInt(st.nextToken());
		}
		arr = dp;
		for(int i = 1; i < n; i++) {
			dp[i]=Math.max(arr[i], dp[i-1]+arr[i]);
		}
		
		Arrays.sort(dp);
	
		System.out.println(dp[n-1]);
		
		
		
		
	}
}
