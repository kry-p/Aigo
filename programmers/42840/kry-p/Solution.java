import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    
    public static final int[] STUDENT_TWO_PICK = {2,1,2,3,2,4,2,5};
    public static final int[] STUDENT_THREE_PICK = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] result = new int[3];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j = 0; j < answers.length; j++) {
                if (student(i, j) == answers[j])
                    sum += 1;
            }
            result[i] = sum;
        }
        int max = Arrays.stream(result).max().getAsInt();
        for(int i = 0; i < result.length; i++)
            if(result[i] == max)
                list.add(i + 1);

        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    public int student(int studentNumber, int current) {
        switch(studentNumber) {
            case 0:
                return (current % 5) + 1;
            case 1:
                return STUDENT_TWO_PICK[current % 8];
            case 2:
                return STUDENT_THREE_PICK[current % 10];
            default:
                return 0;
        } 
    }
    
}