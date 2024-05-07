class Solution {
    public static long solution(long w, long h) {
        return w*h - (w + h - gcd(w,h));
    }
    
    static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        
        return gcd(b, a%b);
    }
}