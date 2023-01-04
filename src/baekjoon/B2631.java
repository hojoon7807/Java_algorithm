package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2631 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] inputs = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 1;

    for (int i = 1; i < N; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (inputs[i] > inputs[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }

    Arrays.sort(dp);

    System.out.println(N - dp[N-1]);
  }

}
