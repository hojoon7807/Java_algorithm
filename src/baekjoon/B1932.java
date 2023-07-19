package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1932 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      
      arr[i] = row;
    }
    
    int[][] dp = new int[n][n];

    dp[0][0] = arr[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (j - 1 < 0) {
          dp[i][j] = dp[i - 1][j] + arr[i][j];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
        }
      }
    }

    int answer = 0;
    for (int i : dp[n - 1]) {
      answer = Math.max(i, answer);
    }
    System.out.println(answer);
  }

}
