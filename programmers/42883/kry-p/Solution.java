class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();
        
        int pos = 0;
        int max = 0;

        for(int i = 0; i < number.length() - k; i++) {
            max = 0;
            
            for(int j = pos; j <= k + i; j++) {
                if(max < (number.charAt(j) - '0')) {
                    max = number.charAt(j) - '0';
                    pos = j + 1;
                }
            }
            builder.append(max);
        }
        
        return builder.toString();
    }
}