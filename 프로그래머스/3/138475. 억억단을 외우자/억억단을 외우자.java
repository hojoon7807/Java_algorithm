import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        // 억 * 억 행렬에서 s <= x <= e 중 가장 많이 등장하는 수
        
        // 대각선 기준으로 반 * 2
        // e 이상의 수는 체크 필요 없음 e 5,000.000
    
        int[][] store = new int[e+1][2];
        store[e][0] = calculateCount(e);
        store[e][1] = e;
        
        for(int i=e-1; i>=1; i--){
            int count = calculateCount(i);
            
            if(count >= store[i+1][0]){
                store[i][0] = count;
                store[i][1] = i;
            } else {
                store[i][0] = store[i+1][0];
                store[i][1] = store[i+1][1];
            }
        }
        
        for(int i=0; i<starts.length; i++){
            answer[i] = store[starts[i]][1];
        }
        
        return answer;
    }
    
    public int calculateCount(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=2; i*i<=n; i++){
            while(n % i == 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            }    
        }
        
        if(n != 1){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        
        int count = 1;
        
        for(Entry<Integer, Integer> entry : map.entrySet()){
            count *= (entry.getValue() + 1);
        }
        
        return count;
    }
}