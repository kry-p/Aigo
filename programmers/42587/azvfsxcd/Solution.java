import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        int answer = 1;
        for(int i = 0 ; i < priorities.length; i++){
            queue.add(priorities[i]);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                    // System.out.println(i + " " + priorities[i] + " " + answer + " " + queue.peek());
                if (priorities[i] == queue.peek()) {
                    if (location == i) {
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        
        return answer;
    }
}