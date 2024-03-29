package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2688 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t;
  static long[][] dp = new long[65][10];


  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    StringBuilder sb = new StringBuilder();
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < 10; i++) {
        dp[1][i] = 1;
      }

      for (int i = 2; i <= n; i++) {
        for (int j = 0; j < 10; j++) {
          for (int k = j; k < 10; k++) {
            dp[i][j] += dp[i-1][k];
          }
        }
      }

      long answer = 0;

      for (int i = 0; i < 10; i++) {
        answer += dp[n][i];
      }

      sb.append(answer).append("\n");
      dp = new long[65][10];
    }

    System.out.println(sb);
  }

}
