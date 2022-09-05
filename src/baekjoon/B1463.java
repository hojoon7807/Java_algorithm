package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N + 1];

    dp[0] = dp[1] = 0;

    for (int i = 2; i < N+1; i++) {
      dp[i] = dp[i-1] + 1;
      if(i % 3 == 0){
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }

      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }
    }

    System.out.println(dp[N]);
  }
}
