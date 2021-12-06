class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 3; i <= 2497; i++) {
            for(int j = 3; j <= 2497; j++) {
                if((i + j) > 2500)
                    continue;
                
                if((i - 2) * (j - 2) == yellow && (2 * (i + j) - 4) == brown) {
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}