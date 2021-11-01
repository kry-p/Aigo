import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> printQueue = new LinkedList<>();
        Queue<Integer> position = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            position.offer(i);
            printQueue.offer(priorities[i]);
        }
        int attempt = 0;
        while (true) {
            if (printQueue.isEmpty())
                break;
            int currentPoll = printQueue.peek();
            if (currentPoll < Collections.max(printQueue)) {
                printQueue.add(printQueue.poll());
                position.add(position.poll());
            } else {
                printQueue.poll();
                attempt += 1;
                if (position.poll() == location) {
                    answer = attempt;
                    break;
                }
            }
        }

        return answer;
    }
}