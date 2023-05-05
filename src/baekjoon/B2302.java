package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2302 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    dp[0] = 1;
    dp[1] = 1;

    int answer = 1;

    int M = Integer.parseInt(br.readLine());

    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    int vip;
    int previousSit = 0;
    for (int i = 0; i < M; i++) {
      vip = Integer.parseInt(br.readLine());
      answer *= dp[vip - previousSit - 1];
      previousSit = vip;
    }

    answer *= dp[N-previousSit];

    System.out.println(answer);
  }

}
