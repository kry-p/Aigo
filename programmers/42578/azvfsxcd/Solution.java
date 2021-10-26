import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 1) + 1);
        }


        for (Integer value : hash.values()) {
            answer *= value;
        }
        return answer-1;
    }
}