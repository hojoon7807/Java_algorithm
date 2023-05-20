package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14501 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] plan = new int[N + 1][2];

    for (int i = 1; i <= N; i++) {
      String[] input = br.readLine().split(" ");
      plan[i] = new int[]{Integer.parseInt(input[0]),Integer.parseInt(input[1])};
    }

    int[] dp = new int[N + 2];

    for (int i = N; i >= 1; i--) {
      if (i + plan[i][0] > N + 1) {
        dp[i] = dp[i+1];
        continue;
      }

      dp[i] = Math.max(dp[i + 1], dp[i + plan[i][0]] + plan[i][1]);
    }

    System.out.println(dp[1]);
  }

}
