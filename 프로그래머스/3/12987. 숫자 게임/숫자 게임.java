import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        
        int aIdx = 0;
        int bIdx = 0;
        
        int answer = 0;
        while(bIdx < len){
            int a = A[aIdx];
            int b = B[bIdx];
            
            if(a < b){
                answer++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }
        
        return answer;
    }
}