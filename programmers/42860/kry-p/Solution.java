class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            int fromStart = name.charAt(i) - 65;
            int fromEnd = 90 - name.charAt(i) + 1;
            
            answer += Math.min(fromStart, fromEnd);
            
            int nextPos = i + 1;
            while(nextPos < name.length() && name.charAt(nextPos) == 'A')
                nextPos += 1;
            
            move = Math.min(move, name.length() - nextPos + 2 * i);
        }
        
        answer += move;
        
        return answer;
    }
}