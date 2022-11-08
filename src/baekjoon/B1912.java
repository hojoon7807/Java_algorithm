package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1912 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N];

    String[] split = br.readLine().split(" ");
    dp[0] = Integer.parseInt(split[0]);
    int max = dp[0];

    for (int i = 1; i < N; i++) {
      int recent = Integer.parseInt(split[i]);
      dp[i] = Math.max(recent + dp[i-1], recent);

      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }

}
