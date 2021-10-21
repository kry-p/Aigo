import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return (str2+str1).compareTo(str1+str2);
            }
        });
        
        if (arr[0].equals("0")) return "0";
        
        for(int i = 0; i < numbers.length; i++){
            answer += arr[i];
        }
        
        return answer;
        
    }
}