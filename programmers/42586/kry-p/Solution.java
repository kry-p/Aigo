import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        int day = 1;

        for (int i : progresses)
            queue.add(i);

        for (int i : speeds)
            speed.add(i);

        while (!queue.isEmpty()) {
            int count = 0;

            while (queue.peek() + (speed.peek() * day) < 100)
                day += 1;
            while (!queue.isEmpty() && queue.peek() + (speed.peek() * day) >= 100) {
                queue.remove();
                speed.remove();
                count += 1;
            }
            if (count > 0)
                result.add(count);
        }
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}