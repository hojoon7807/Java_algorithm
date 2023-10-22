package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[][] dp = new int[n+1][2];

    dp[1][0] = 0;
    dp[1][1] = arr[0];

    if (n >= 2) {
      dp[2][0] = arr[1];
      dp[2][1] = arr[0] + arr[1];
    }

    for (int i = 3; i <= n; i++) {
      dp[i][0] = Math.max(dp[i-2][1] + arr[i-1], dp[i-2][0] + arr[i-1]);
      dp[i][1] = dp[i-1][0] + arr[i-1];
    }

    System.out.println(Math.max(dp[n][0], dp[n][1]));
  }

}
