class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length();
        int index = 0;
        char max;
        
        for(int i = 0; i < len - k; i++){
            max = '0';
            for(int j = index; j <= k + i; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    index = j + 1;
                }
                if(max == '9')
                    break;
            }
            answer += max + "";
        }
        return answer;
    }
}