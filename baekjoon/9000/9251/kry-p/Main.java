import java.io.*;

public class Main {
    public static int[][] dp;
    public static String s1, s2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1 = reader.readLine();
        s2 = reader.readLine();

        dp = new int[1000 + 1][1000 + 1];

        for (int i = 0; i < 1001; i++) 
            for (int j = 0; j < 1001; j++)
                dp[i][j] = -1;

        System.out.print(lcs(s1.length() - 1, s2.length() - 1));
    }

    private static int lcs(int x, int y) {
        if (x == -1 || y == -1) return 0;
        if (dp[x][y] == -1) {
            dp[x][y] = 0;

            if (s1.charAt(x) == s2.charAt(y)) dp[x][y] = lcs(x - 1, y - 1) + 1;
            else dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
        }
        return dp[x][y];
    }
}