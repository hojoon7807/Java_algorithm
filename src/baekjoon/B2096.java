package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] dp = new int[4][4];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int i0 = Integer.parseInt(st.nextToken());
      int i1 = Integer.parseInt(st.nextToken());
      int i2 = Integer.parseInt(st.nextToken());

      if (i == 0) {
        dp[0][3] = i0;
        dp[1][3] = i1;
        dp[2][3] = i2;

        dp[3][0] = i0;
        dp[3][1] = i1;
        dp[3][2] = i2;

        continue;
      }

      int maxTmp0 = dp[0][3];
      int maxTmp1 = dp[1][3];
      dp[0][3] = Math.max(dp[0][3], dp[1][3]) + i0;
      dp[1][3] = Math.max(maxTmp0, Math.max(dp[1][3], dp[2][3])) + i1;
      dp[2][3] = Math.max(maxTmp1, dp[2][3]) + i2;

      int minTmp0 = dp[3][0];
      int minTmp1 = dp[3][1];
      dp[3][0] = Math.min(dp[3][0], dp[3][1]) + i0;
      dp[3][1] = Math.min(minTmp0, Math.min(dp[3][1], dp[3][2])) + i1;
      dp[3][2] = Math.min(minTmp1, dp[3][2]) + i2;
    }

    System.out.println(Math.max(dp[0][3], Math.max(dp[1][3], dp[2][3])));
    System.out.println(Math.min(dp[3][0], Math.min(dp[3][1], dp[3][2])));
  }

}
