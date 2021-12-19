class Solution {
    public static int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int current, int sum) {
        if(current == numbers.length) {
            if(sum == target) 
                answer += 1;
            return;
        }
        
        sum += numbers[current];
        dfs(numbers, target, current + 1, sum);
        
        sum -= numbers[current];
        sum += (-1 * numbers[current]);
        dfs(numbers, target, current + 1, sum);
    }
}