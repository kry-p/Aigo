import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};

        Stack<Integer> s0 = new Stack<>();
        Stack<Integer> s1 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = prices.length; i > 0; i--) {
            s0.push(prices[i - 1]);
        }

        while (true) {
            if (s0.isEmpty())
                break;

            int current = s0.pop(); // 현재 비교 대상
            int duration = 0;
            // 스택이 빌 때까지 비교
            while (!s0.isEmpty()) {
                duration += 1;
                int compare = s0.pop();
                s1.push(compare);

                if (current > compare) {
                    break;
                }
            }
            result.add(duration);

            while (!s1.isEmpty()) {
                s0.push(s1.pop());
            }

            // 종료조건
            if (result.size() >= prices.length)
                break;
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}