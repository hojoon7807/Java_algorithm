package programmers;

import java.util.Arrays;

public class 등굣길 {

  public static void main(String[] args) {
    등굣길 m = new 등굣길();
    System.out.println(m.solution(4, 3, new int[][]{{2, 2}}));
  }

  int[][] dp;
  int m, n;
  int mod = 1000000007;

  public int solution(int m, int n, int[][] puddles) {
    this.m = m;
    this.n = n;
    dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int[] puddle : puddles) {
      dp[puddle[1]][puddle[0]] = 0;
    }

    return max(1, 1);
  }

  public int max(int r, int c) {
    if (r > n || c > m) {
      return 0;
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    if (r == n && c == m) {
      return 1;
    }

    return dp[r][c] = (max(r + 1, c) + max(r, c + 1)) % mod;
  }

}
