import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t > 0){
            t--;
            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            
            if(k == 1){
                sb.append("1 1").append("\n");
                continue;
            }
            
            // 정확히 k개 있는 가장 작은 길이
            // 정확히 k개 있고 시작 끝이 같은 가장 긴 길이
            int[] alpha = new int[26];
            int min = 10001;
            int max = 0;
            for(char c:w){
                alpha[c - 'a']++;
            }
            // case 1
            for(int i=0; i<w.length; i++){
                char c = w[i];
                
                if(alpha[c - 'a'] < k){
                    continue;
                }
                
                int count = 1;
                for(int j=i+1; j<w.length; j++){
                    if(w[i] == w[j]){
                        count++;
                    }
                    
                    if(count == k){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            
            if(max==0){
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}