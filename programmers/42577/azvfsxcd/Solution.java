import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        
        // for(int i =0; i<phone_book.length; i++){
        //     for(int j =i+1; j<phone_book.length; j++){
        //         // 접두어 인지 체크
        //         // indexOf > 앞의 문자열에서 문자 찾기
        //         if(phone_book[j].indexOf(phone_book[i])==0){
        //             return false;   
        //         }
        //     }
        // }
        
        
        return true;
    }
}