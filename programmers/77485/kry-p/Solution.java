import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        int temp = 0;
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                temp += 1;
                map[i][j] = temp;
            }
        }
        
        int direction = 1;
        int pos = 0;
        for (int[] query : queries) {
            int currentX = query[0], currentY = query[1];
            int dx = query[2] - query[0];
            int dy = query[3] - query[1];
            
            // 가져오기
            for (int j = 0; j < 2; j++){
                for (int i = 0; i < dx; i++) {
                    currentX += direction;
                    deque.addFirst(map[currentX][currentY]);
                }
                for (int i = 0; i < dy; i++) {
                    currentY += direction;
                    deque.addFirst(map[currentX][currentY]);
                }
                direction *= -1;
            }
            // 이동
            deque.addFirst(deque.pollLast());
            
            int min = Integer.MAX_VALUE;
            dx = query[2] - query[0];
            dy = query[3] - query[1];
            // 적용
            for (int j = 0; j < 2; j++){
                for (int i = 0; i < dx; i++) {
                    currentX += direction;
                    map[currentX][currentY] = deque.pollLast();
                    min = Math.min(map[currentX][currentY], min);
                }
                for (int i = 0; i < dy; i++) {
                    currentY += direction;
                    map[currentX][currentY] = deque.pollLast();
                    min = Math.min(map[currentX][currentY], min);
                }
                direction *= -1;
            }
            answer[pos] = min;
            pos += 1;
            
            deque = new ArrayDeque<>();
            
        }
        return answer;
    }
}