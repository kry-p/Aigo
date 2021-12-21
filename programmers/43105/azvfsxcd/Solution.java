class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] arr = new int[n][n];
        int max=0;
        
        arr[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            arr[i][0] = arr[i-1][0] + triangle[i][0];
            arr[i][i] = arr[i-1][i-1] + triangle[i][i];
        }
        
        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++){
                arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + triangle[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            if(max < arr[n-1][i])
                max = arr[n-1][i];
        }
        answer = max;
        return answer;
    }
}