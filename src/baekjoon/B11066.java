package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11066 {

  static int[] num;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      num = new int[n];
      dp = new int[n][n];

      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        num[j] = Integer.parseInt(input[j]);
      }

      for (int j = 1; j < n; j++) {
        for (int k = j - 1; k >= 0; k--) {
          int min = Integer.MAX_VALUE;
          for (int l = 0; l < j - k; l++) {
            min = Math.min(min, dp[k][k + l] + dp[k + l + 1][j]);
          }
          dp[k][j] = min + getSum(k, j);
        }
      }

      sb.append(dp[0][n - 1]).append("\n");

      /**
       * 40 30 30 50
       *
       * ab
       *
       * 60 + 100
       * 60 + 110
       * dp[n][n]
       *
       *
       * dp[x][y] = min ( dp[x][z] + dp[z+1][y]
       *
       * dp[a][c] = dp[a][a] + dp[b][c], dp[a][b] + dp[c][c]
       *   a  b  c        d  e
       * a 0  ab bc+abc
       * b    0  bc
       * c       0        cd
       * d                0  de
       * e                    0
       * */
    }

    System.out.println(sb);
  }

  static int getSum(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += num[i];
    }

    return sum;
  }
}
