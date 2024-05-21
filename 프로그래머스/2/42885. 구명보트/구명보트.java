import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 30 30 70 70 limit 100
        // 30 + 30, 70, 70
        // 30 + 70, 30 + 70
        
        // 구명 보트는 최대 2명
        // 가벼운 사람 + 무거운 사람
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            answer++;
            
            if(left == right){
                break;
            }
            
            int sum = people[left] + people[right];
            // 같이 태울 수 있는 경우            
            if(sum <= limit){
                left++;
                right--;
            } else {
                right--;
            }
        }

        return answer;
    }
}