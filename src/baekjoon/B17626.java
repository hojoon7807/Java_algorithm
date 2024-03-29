package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17626 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        min = Math.min(min, dp[i - j * j] + 1);
      }
      dp[i] = min;
    }

    System.out.println(dp[N]);
  }
}
