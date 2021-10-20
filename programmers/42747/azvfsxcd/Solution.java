import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);     // 0 1 3 5 6 
        // int max = citations[citations.length-1];
        // System.out.println(i + " " + m +" "+answer);
        for(int i = 0 ; i < citations.length; i++){
            if(citations[i]>=citations.length-i){
                // System.out.println(r + " " + citations.length + " " + i);
                answer = citations.length-i;
                break;
            }
             
        }
        return answer;
    }
}