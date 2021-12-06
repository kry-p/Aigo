import java.util.Arrays;

class Solution {
    private final static int DIVISOR = 1000000007;
    private static long[][] map, path;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new long[n][m];
        path = new long[n][m];
        
        for(long arr[] : map) 
            Arrays.fill(arr, 1);
        
        for(int i = 0; i < puddles.length; i++) 
            map[puddles[i][1] - 1][puddles[i][0] - 1] = 0;
        
        path[0][0] = map[0][0];
        
        for(int i = 1; i < n; i++) {
            if(map[i][0] == 0)
                path[i][0] = 0;
            else
                path[i][0] = path[i - 1][0] % DIVISOR;
        }
        
        for(int i = 1; i < m; i++) {
            if(map[0][i] == 0) 
                path[0][i] = 0;
            else
                path[0][i] = path[0][i - 1] % DIVISOR;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == 0)
                    path[i][j] = 0;
                else
                    path[i][j] = (path[i - 1][j] + path[i][j - 1]) % DIVISOR;
            }
        }
        
        answer = Math.toIntExact(path[n - 1][m - 1]);
        
        return answer;
    }
}