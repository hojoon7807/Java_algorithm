package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17404 {


  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[][] cost;
  static int[][] dp;
  static int max = 1000 * 1000 + 1;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

    cost = new int[n][3];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        cost[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

  static void solution() {
    /*
    1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
    N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
    i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.

     n = 3
     R G B
     R B G
     G R B
     G B R
     B R G
     B G R

     n = 4
     R G B G
     R B G B

     n = 5
     R B G R B
     R G B R B
     */

    dp = new int[n+1][3];

    int answer = max;
    // first color
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          dp[0][i] = cost[0][i];
        } else {
          dp[0][j] = max;
        }
      }

      for (int j = 1; j < n ; j++) {
        dp[j][0] =  Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
        dp[j][1] =  Math.min(dp[j-1][0], dp[j-1][2]) + cost[j][1];
        dp[j][2] =  Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];
      }

      for (int j = 0; j < 3; j++) {
        if (i != j) {
          answer = Math.min(dp[n-1][j], answer);
        }
      }
    }

    System.out.println(answer);
  }
}
