import java.util.*;
import java.util.Map.Entry;

class Solution {

    HashMap<Integer, Long> map = new HashMap<>();
    PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int t: tangerine){
            map.put(t, map.getOrDefault(t, 0L) + 1);
        }
        
        for(Entry<Integer, Long> entry: map.entrySet()){
            pq.add(entry.getValue());
        }
        
        while(k > 0) {
            Long count = pq.poll();
            answer++;
            k -= count;
        }
        return answer;
    }
    
}