import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        boolean[] visited = new boolean[name.length()];
        boolean[] allTrue = new boolean[name.length()];
        for(int i = 0; i < visited.length; i++){
            if(name.charAt(i) == 'A') visited[i] = true;
            allTrue[i] = true;
        }

        boolean isRight = true;
        int cursor = 0; //커서위치
        while(true){

            if(Arrays.equals(allTrue, visited)) break;

            int up = name.charAt(cursor) - 'A';
            int down = 'Z' - name.charAt(cursor) + 1;
            int right = cursor;
            int left = cursor;
            int rightCount = 0;
            int leftCount = 0;

            if(visited[cursor]){
                if(cursor != 0){
                    if(isRight){ //오른쪽 이동 중일때
                        right--;
                        left--;
                    }else{ //왼쪽 이동 중일때
                        right++;
                        left++;
                    }
                }

                for(int j = 0; j < visited.length; j++){
                    if(!visited[right]) break;
                    right = (right+1) % visited.length;
                    rightCount++;
                }

                for(int j = 0; j < visited.length; j++){
                    if(!visited[left]) break;
                    left--;
                    if(left == -1) left = visited.length-1;
                    leftCount++;
                }

                if(rightCount <= leftCount) {
                    cursor = right;
                    answer += rightCount;
                    isRight = true;
                } else{
                    cursor = left;
                    answer += leftCount;
                    isRight = false;
                }

                continue;

            }else{
                visited[cursor] = true;
                answer += Math.min(up, down);
                if(isRight){
                    cursor= (cursor + 1) %visited.length;
                }else{
                    cursor--;
                    if(cursor == -1) cursor = visited.length-1;
                }
                if(!visited[cursor]) answer++;
            }
        }

        return answer;
    }
}