import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    public static boolean[] isUsed;
    public static ArrayList<String> route;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        route = new ArrayList<>();
        isUsed = new boolean[tickets.length];
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(route);
        
        return route.get(0).split(" ");
    }
    
    public void dfs(String current, String order, int pos, String[][] tickets) {
        if(pos == tickets.length) {
            route.add(order);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!isUsed[i] && tickets[i][0].equals(current)) {
                isUsed[i] = true;
                dfs(tickets[i][1], order + " " + tickets[i][1], pos + 1, tickets);
                isUsed[i] = false;
            }
        }
    }
}