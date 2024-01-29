package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15483 {

  static BufferedReader br;
  static String first, second;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    input();
    solution();
  }

  static void input() throws IOException {
    first = br.readLine();
    second = br.readLine();
  }

  static void solution() {
    int[][] dp = new int[first.length() + 1][second.length() + 1];

    for (int i = 0; i <= first.length(); i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= second.length(); i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= first.length(); i++) {
      for (int j = 1; j <= second.length(); j++) {
        if (first.charAt(i - 1) == second.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
      }
    }

    System.out.println(dp[first.length()][second.length()]);
  }
}
