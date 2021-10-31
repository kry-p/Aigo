import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        // 다리를 건너는 트럭
        Queue<Integer> queue = new LinkedList<Integer>();
        // for(int i = 0; i < truck_weights.length; i++){
        for(int i : truck_weights){
            while(true){
                // System.out.println(queue.peek());
                // for(int a : queue){
                //     System.out.print("i: "+ i +" a: " + a + " ");
                // }
                // System.out.println();
                if(bridge_length == queue.size()){
                    sum -= queue.poll();
                } else {
                    if(i + sum > weight){
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.add(i);
                        answer++;
                        sum += i;
                        break;
                        
                    }
                }
            }

        }
        return answer+bridge_length;
    }
}