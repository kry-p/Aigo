class Solution {
    public static boolean[] isChecked;
    public static int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        isChecked = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!isChecked[i]){
                dfs(i, computers);   
                answer += 1;
            }
        }
        return answer;
    }
    
    public void dfs(int current, int[][] computers) {
        isChecked[current] = true;
    
        for(int i = 0; i < isChecked.length; i++) {
            if(computers[current][i] == 1 && !isChecked[i] && current != i)
                dfs(i, computers);
        }
    }
}