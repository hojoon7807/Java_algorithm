import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 임의의 사원보다 두 점수가 모두 낮으면 인센을 못 받음
        //[4,3], [5,2], [5,1], [4,5], [4,4]
        //w = 4,3
        //[5,2] [5,1] [4,5] [4,4] [4,3]
        int[] wanho = scores[0];
        
        Arrays.sort(scores, (o1,o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            
            return o2[0]-o1[0];
        } );
        
        int seq = 1;
        int wSum = wanho[0] + wanho[1];
        
        int[] max = scores[0];
        
        for(int[] score : scores){
            // 인센티브 x
            if(wanho[0] < max[0] && wanho[1] < max[1]){
                return -1;
            }
            
            if(score[0] < max[0] && score[1] < max[1]){
                continue;
            }
            
            if(score[1] > max[1]){
                max = score;
            }
            
            int oSum = score[0] + score[1];
            
            if(oSum > wSum){
                seq++;
            }
        }
     
        return seq;
    }
}