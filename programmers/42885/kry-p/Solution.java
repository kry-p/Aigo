import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        while (left <= right) {
            if ((people[left] + people[right]) > limit) {
                right -= 1;
                answer += 1;
            } else {
                left += 1; 
                right -= 1;
                answer += 1;
            }
        }
    
        return answer;
    }
}