import java.util.*;
import java.util.Map.Entry;

class Solution {

    HashMap<Integer, Long> map = new HashMap<>();
    PriorityQueue<Tangerine> pq = new PriorityQueue<>((o1, o2) -> o2.count.compareTo(o1.count));
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int t: tangerine){
            map.put(t, map.getOrDefault(t, 0L) + 1);
        }
        
        for(Entry<Integer, Long> entry: map.entrySet()){
            pq.add(new Tangerine(entry.getKey(), entry.getValue()));
        }
        
        while(k > 0) {
            Tangerine t = pq.poll();
            answer++;
            k -= t.count;
        }
        return answer;
    }
    
    static class Tangerine {
        int num;
        Long count;
        
        public Tangerine(int num, Long count){
            this.num = num;
            this.count = count;
        }
    }
}