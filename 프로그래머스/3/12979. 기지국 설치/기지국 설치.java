class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int networkLen = (w << 1) + 1;
        int cur = 1;
        
        for(int station : stations){
            // 전파 가능 시작 범위
            int start = station - w;
            
            //System.out.println("전파 시작: " + start);
            if(start > cur){
                int range = start - cur;
               // System.out.println("범위: " + range);

                while(range > 0){
                    answer++;
                    range -= networkLen;
                }
            }
            
            cur = station + w + 1;
        }
        
        int lastRange = n - cur + 1;
        
        while(lastRange > 0){
            answer++;
            lastRange -= networkLen;
        }

        return answer;
    }
}