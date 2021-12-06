class Solution {
    private static int[][] max;
    public int solution(int[][] triangle) {
        int answer = 0;
        max = new int[triangle.length][triangle.length];
        
        max[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    max[i][j] = max[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    max[i][j] = max[i - 1][j - 1] + triangle[i][j];
                } else {
                    max[i][j] = Math.max(max[i - 1][j - 1], max[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int i = 0; i < max[triangle.length - 1].length; i++) {
            if (max[triangle.length - 1][i] > answer)
                answer = max[triangle.length - 1][i];
        }
        
        return answer;
    }
}