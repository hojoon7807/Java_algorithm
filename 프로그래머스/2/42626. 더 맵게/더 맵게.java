import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s:scoville){
            pq.add(s);
        }
        
        int answer = 0;
        
        while(pq.peek() < K){
            answer++;
            
            if(pq.size() < 2){
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int sum = first + second * 2;
            
            pq.add(sum);
        }
        
        return answer;
    }
}