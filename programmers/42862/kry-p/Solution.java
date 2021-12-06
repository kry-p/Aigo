import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] list = new int[n + 1];
        Arrays.fill(list, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i : lost) 
            list[i] -= 1;
        
        for(int i : reserve)
            list[i] += 1;
        
        for(int currentLost : lost) {
            int prev = currentLost - 1;
            int next = currentLost + 1;
            
            for(int currentReserve : reserve) {
                if(prev == currentReserve || next == currentReserve) {
                    if(list[currentReserve] > 1 && list[currentLost] == 0) {
                        list[currentLost] += 1;
                        list[currentReserve] -= 1;
                    }
                }
            }
        }
        
        for(int i = 1; i < list.length; i++)
            if(list[i] > 0)
                answer += 1;
        
        return answer;
    }
}