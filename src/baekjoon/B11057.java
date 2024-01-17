package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11057 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long[][] dp = new long[1001][10];


  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = j; k < 10; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= 10007;
        }
      }
    }

    long answer = 0;

    for (int i = 0; i < 10; i++) {
      answer += dp[n][i];
      answer %= 10007;
    }

    System.out.println(answer);
  }

}
