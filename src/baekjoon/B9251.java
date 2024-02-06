package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {
  static String s1;
  static String s2;

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    s1 = br.readLine();
    s2 = br.readLine();
  }

  static void solution (){
    // ACAYKP와 CAPCAK의 LCS는 ACAK
    // ACAYKP
    // CAPCAK
    // i 부터 j 의 최장 길이 + 1
    // s1의 i 번째 까지와 s2의 j번째 까지 비교

    // i번째와 j번째의 문자가 같은경우  dp[i][j] = dp[i-1][j-1] + 1;
    // 다른경우 dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 1; i <= s1.length() ; i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    System.out.println(dp[s1.length()][s2.length()]);

  }
}
