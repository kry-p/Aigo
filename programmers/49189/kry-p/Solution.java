import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];
    
        for(int i = 0; i < edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1); // 초깃값
        
        int max = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int i = 2; i <= n; i++) {
                if(distance[i] == 0 && map[current][i]) {
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                    max = Math.max(max, distance[i]);
                }
            }
        }
        for(int dist : distance) {
            if(max == dist)
                answer += 1;
        }
        
        return answer;
    }
}