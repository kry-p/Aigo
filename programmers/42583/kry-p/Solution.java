import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truckQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();
        ArrayList<Integer> finishedTruck = new ArrayList<>();
        int size = truck_weights.length;
        int currentWeight = 0;

        for (int i = 0; i < bridge_length; i++)
            bridgeQueue.offer(0);

        for (int w : truck_weights)
            truckQueue.offer(w);

        while (true) {
            answer += 1;
            // 다리 내에서 트럭 이동
            // 0은 비어 있는 상태
            if (bridgeQueue.peek() != 0) {
                currentWeight -= bridgeQueue.peek(); // 현재 다리 중량 감소
                finishedTruck.add(bridgeQueue.poll());
            } else {
                bridgeQueue.poll();
            }

            // 다리로 트럭 이동
            if (truckQueue.peek() == null) {
                bridgeQueue.offer(0);
            } else {
                if ((currentWeight + truckQueue.peek()) <= weight) {
                    currentWeight += truckQueue.peek(); // 현재 다리 중량 증가
                    bridgeQueue.offer(truckQueue.poll());
                } else {
                    bridgeQueue.offer(0);
                }
            }

            // 종료조건
            if (finishedTruck.size() >= size)
                break;
        }

        return answer;
    }
}