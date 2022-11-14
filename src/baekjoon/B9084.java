package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9084 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int M = Integer.parseInt(br.readLine());

      int[] dp = new int[M + 1];

      dp[0] = 1;

      for (int coin : arr) {
        for (int i = coin; i <=M; i++) {
          dp[i] += dp[i - coin];
        }
      }

      sb.append(dp[M] + "\n");
    }

    System.out.println(sb);
  }

}
