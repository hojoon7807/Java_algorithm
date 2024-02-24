package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9252 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String a, b;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    a = br.readLine();
    b = br.readLine();
  }

  static void solution() {
    int[][] dp = new int[a.length() + 1][b.length() + 1];

    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= b.length(); j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    String lcs = backTracking(a.length(), b.length(), dp);

    if (lcs.length() == 0) {
      System.out.println(0);
    } else {
      System.out.println(lcs.length());
      System.out.println(lcs);
    }
  }

  static String backTracking(int i, int j, int[][] dp) {
    if (i == 0 || j == 0) {
      return "";
    }

    if (a.charAt(i - 1) == b.charAt(j - 1)) {
      return backTracking(i - 1, j - 1, dp) + a.charAt(i - 1);
    } else {
      if (dp[i - 1][j] >= dp[i][j - 1]) {
        return backTracking(i - 1, j, dp);
      } else {
        return backTracking(i, j - 1, dp);
      }
    }
  }

}
