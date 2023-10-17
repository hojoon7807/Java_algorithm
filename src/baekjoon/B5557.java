package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5557 {

  static int n;
  static int[] arr;
  static long[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    dp = new long[n][21];

    String[] input = br.readLine().split(" ");


    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    dp[0][arr[0]] = 1;

    for (int i = 1; i < n-1; i++) {
      for (int j = 0; j <= 20; j++) {
        if (dp[i-1][j] != 0) {
          int a = j + arr[i];
          int b = j - arr[i];
          if (a <= 20) {
            dp[i][a] += dp[i-1][j];
          }

          if (b >= 0) {
            dp[i][b] += dp[i-1][j];
          }
        }
      }
    }

    System.out.println(dp[n-2][arr[n-1]]);
  }

}
