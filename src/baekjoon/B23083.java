package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B23083 {

  static int N;
  static int M;
  static long[][] dp;
  static int MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    dp = new long[N + 2][M + 1];

    for (long[] ints : dp) {
      Arrays.fill(ints, -1);
    }

    dp[1][1] = 1;

    for (int i = 0; i <= N; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i <= M; i++) {
      dp[0][i] = 0;
      dp[N + 1][i] = 0;
    }

    int K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      dp[x][y] = 0;
    }

    System.out.println(dfs(N, M));

  }

  static long dfs(int r, int c) {
    if (dp[r][c] != -1) {
      return dp[r][c];
    }

    if (c % 2 == 0) {
      return dp[r][c] = (dfs(r - 1, c) + dfs(r, c - 1) + dfs(r + 1, c - 1)) % MOD;
    } else {
      return dp[r][c] = (dfs(r - 1, c) + dfs(r, c - 1) + dfs(r - 1, c - 1)) % MOD;
    }
  }

}
