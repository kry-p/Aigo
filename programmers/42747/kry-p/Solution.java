import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        Arrays.sort(citations);

        for (int i = 1; i <= size; i++) {
            if (citations[size - i] >= i)
                answer = i;
        }

        return answer;
    }
}