import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T207_BOJ9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 상근이가 홀수일 때 이김
        /*
          		상근	창영
          	1	o
          	2		o
          	3	o	
          	4		o	(1개를 가져가든 3개를 가져가든 창영이 이겨)
          	5	o		(마찬가지)
          	6		o
         */
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 0;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-2];

        System.out.print(dp[n]==1? "SK" : "CY");
	   }
}