class Solution {
    private final int[] DX = {0, 0, 1, -1};
    private final int[] DY = {1, -1, 0, 0};
    private int temp;
    private static int[][] picture;
    
    public int[] solution(int m, int n, int[][] picture) {
        this.picture = new int[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        // 배열 복사 (Deep copy)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.picture[i][j] = picture[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.picture[i][j] > 0) {
                    temp = 0;
                    dfs(this.picture[i][j], i, j);
                    numberOfArea += 1;
                }
                maxSizeOfOneArea = Math.max(temp, maxSizeOfOneArea);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    private void dfs(int color, int x, int y) {
        this.picture[x][y] = 0;
        temp += 1;
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];
            
            if (nextX < 0 || nextY < 0 || nextX >= this.picture.length || nextY >= this.picture[0].length || this.picture[nextX][nextY] != color)
                continue;
        
            dfs(color, nextX, nextY);
        }
    }
}