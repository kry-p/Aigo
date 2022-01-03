import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<Integer> operation = new ArrayList<>(); // 0 : enter, 1 : leave
        HashMap<String, String> users = new HashMap<String, String>();
        ArrayList<String> answerList = new ArrayList<String>();
        
        for (String s : record) {
            String[] splitted = s.split(" ");
            
            if (splitted[0].equals("Enter") || splitted[0].equals("Change"))
                users.put(splitted[1], splitted[2]);
        }
        
        for (String s : record) {
            String[] splitted = s.split(" ");
            
            if (splitted[0].equals("Enter"))
                answerList.add(users.get(splitted[1]) + "님이 들어왔습니다.");
            else if (splitted[0].equals("Leave"))
                answerList.add(users.get(splitted[1]) + "님이 나갔습니다.");
        }
    
        return answerList.toArray(new String[answerList.size()]);
    }
}