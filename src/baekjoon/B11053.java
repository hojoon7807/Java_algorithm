package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11053 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] dp = new int[n];

    dp[0] = 1;

    for (int i = 1; i < n; i++) {
      int max = 0;

      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          max = Math.max(dp[j], max);
        }
      }

      dp[i] = max + 1;
    }

    int answer = 0;

    for (int i : dp) {
      answer = Math.max(i, answer);
    }

    System.out.println(answer);
  }

}
