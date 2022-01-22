import java.util.Stack;

class Solution{
    public int solution(String s) {
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        
        // 문자열의 길이가 홀수이면 완성될 수 없음
        // 또한, 문자열의 길이가 1인 경우 하기 로직에서 빈 스택에 pop하는 오류 발생
        // 해당 문제 예외 처리
        if (s.length() % 2 == 1) 
            return 0;
        
        // 왼쪽 스택에 추가
        for (int i = 0; i < s.length(); i++) 
            leftStack.push(s.substring(i, i + 1));
        
        int count = 0;
        
        while (true) {
            while (!leftStack.isEmpty()) {
                if (rightStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
                if (leftStack.peek().equals(rightStack.peek())) {
                    leftStack.pop();
                    rightStack.pop();
                    count += 1;
                } else {    
                    rightStack.push(leftStack.pop());
                }
            }
            
            while (!rightStack.isEmpty()) {
                if (leftStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
                if (leftStack.peek().equals(rightStack.peek())) {
                    leftStack.pop();
                    rightStack.pop();
                    count += 1;
                } else {
                    leftStack.push(rightStack.pop());
                }
            }
            
            // 완전히 비웠으면 제거 가능
            if (leftStack.size() == 0 && rightStack.size() == 0) {
                return 1;
            }
            
            // 한 바퀴 돌았는데도 제거된 횟수가 0이면 불가능
            if (count == 0) {
                return 0;
            }
            
            count = 0;
        }
    }
}