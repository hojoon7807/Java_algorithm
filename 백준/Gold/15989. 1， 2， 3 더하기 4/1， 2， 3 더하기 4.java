import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            
            // 1,2,3 을 이용해 n을 만드는 방법
            // 1 > 1
            // 2 > 1+1 , 2
            // 3 > 1+1+1, 1+2, 3
            // 4 > 1+1+1+1, 1+1+2, 3+1, 2+2 (1,1,1,1), (1)(1)(1,1), (1)(1,1,1), (1,1)(1,1)
            // 5 > 1+1+1+1+1, 1+1+1+2, 1+1+3, 1+2+2, 2+3
            // 6 > 1+1+1+1+1+1, 1+1+1+1+2, 1+1+1+3, 2+2+2, 1+1+2+2, 3+3, 1+2+3
            // dp[n][1] = dp[n-1][1];
            // dp[n][2] = dp[n-2][2]
            
            int[][] dp;
            
            if(n > 3){
                dp = new int[n+1][4];
            } else {
                dp = new int[4][4];
            }
            dp[1][1] = 1; // 1
            dp[2][1] = 1; // 1+1
            dp[2][2] = 1; // 2
            dp[3][1] = 1; // 1+1+1
            dp[3][2] = 1; // 1+2
            dp[3][3] = 1; // 3
            
            for(int i=4; i<=n; i++){
                dp[i][1] = 1;
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
            t--;
        }
        
        System.out.println(sb);
    }
    
}