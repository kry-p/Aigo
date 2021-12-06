import java.util.Arrays;
import java.util.HashSet;

class Solution {
    private static int[] numberArray, temp;
    private static boolean[] isVisited;
    private static HashSet<Integer> result;
    
    public int solution(String numbers) {
        int answer = 0;
        numberArray = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        temp = new int[numbers.length()];
        isVisited = new boolean[numbers.length()];
        result = new HashSet<Integer>();
        
        for(int i = 1; i <= numberArray.length; i++) 
            search(0, i);            
    
        return result.size();
    }

    public void search(int depth, int size) {
        if(depth == size) {
            StringBuilder builder = new StringBuilder();
            
            for(int i = 0; i < size; i++)
                builder.append(temp[i]);
            int value = Integer.parseInt(builder.toString());
            System.out.println(value);
            
            if(check(value))
                result.add(value);            
        }
        
        for(int i = 0; i < numberArray.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                temp[depth] = numberArray[i];
                search(depth + 1, size);
                isVisited[i] = false;
            }
        }
    }
    
    public boolean check(int number) {
        if(number == 0 || number == 1)
            return false;
        
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}