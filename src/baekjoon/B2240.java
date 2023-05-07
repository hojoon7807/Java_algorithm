package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2240 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int T = Integer.parseInt(input[0]);
    int W = Integer.parseInt(input[1]);

    int[][] dp = new int[T + 1][W + 1];

    for (int i = 1; i <= T; i++) {
      int tree = Integer.parseInt(br.readLine());
      for (int j = 0; j <= W; j++) {
        if (j == 0) {
          if (tree == 1) {
            dp[i][j] = dp[i - 1][j] + 1;
          } else {
            dp[i][j] = dp[i - 1][j];
          }
          continue;
        }

        if (j % 2 == 0) {
          if (tree == 1) {
            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
          }
        } else {
          if (tree == 2) {
            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
          }
        }
      }
    }
    int max = -1;
    for (int i = 0; i <= W; i++) {
      max = Math.max(dp[T][i], max);
    }

    System.out.println(max);
  }

}
