package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1010 {

  static int[][] dp = new int[30][30];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String[] nm = br.readLine().split(" ");
      int N = Integer.parseInt(nm[0]);
      int M = Integer.parseInt(nm[1]);

      System.out.println(combine(M, N));
    }
  }

  static int combine(int n, int r) {
    if (r == n || r == 0) {
      return dp[n][r] = 1;
    }
    if (dp[n][r] > 0) {
      return dp[n][r];
    }

    return dp[n][r] = combine(n - 1, r - 1) + combine(n - 1, r);
  }
}
