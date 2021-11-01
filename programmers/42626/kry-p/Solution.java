import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int s : scoville)
            queue.add(s);

        while (queue.peek() < K) {
            if (queue.size() < 2) {
                answer = -1;
                break;
            }
            int num1 = queue.poll();
            int num2 = queue.poll();

            queue.add(num1 + 2 * num2);
            answer += 1;
        }

        return answer;
    }
}