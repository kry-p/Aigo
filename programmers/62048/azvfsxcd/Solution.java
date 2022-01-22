class Solution {
    public long solution(int w, int h) {
        
        long w1 = Long.valueOf(w);
        long h1 = Long.valueOf(h);
        // System.out.print(gcd(w1, h1));
        return (w1 * h1) - (w1 + h1 - gcd(w1, h1));
    }
    public long gcd(long w, long h){
    
        if(h == 0) {
            return w;
        }
        else {
            return gcd(h, w % h);
        }
    }
}