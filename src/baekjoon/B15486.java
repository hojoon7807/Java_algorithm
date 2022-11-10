package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15486 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] times = new int[N+1];
    int[] pays = new int[N+1];
    int[] dp = new int[N + 1];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      times[i] = Integer.parseInt(input[0]);
      pays[i] = Integer.parseInt(input[1]);
    }


    int max = 0;

    /*
    dp = 0 0 0 10 30 0 20 0
    3 10
    5 20
    1 10
    1 20
    2 15
    4 40
    2 200
     */
    for (int i = 0; i <= N; i++) {
      if (max < dp[i]) {
        max = dp[i];
      }

      int day = i + times[i];

      if (day <= N) {
        dp[day] = Math.max(max+pays[i], dp[day]);
      }
    }
    System.out.println(dp[N]);
  }

}
