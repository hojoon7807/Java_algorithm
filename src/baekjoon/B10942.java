package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10942 {

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int n = Integer.parseInt(br.readLine());
//
//    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//    int m = Integer.parseInt(br.readLine());
//
//    StringBuilder sb = new StringBuilder();
//
//    for (int i = 0; i < m; i++) {
//      int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
//          .toArray();
//
//      int start = testCase[0]-1;
//      int end = testCase[1]-1;
//
//      while (start <= end) {
//        if (arr[start] != arr[end]) {
//          sb.append(0 + "\n");
//          break;
//        }
//
//        start ++;
//        end--;
//      }
//
//      if (start > end) {
//        sb.append(1 + "\n");
//      }
//    }
//
//    System.out.println(sb);
//  }

  private static int[][] dp;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int m = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int i = 0; i < m; i++) {
      int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .toArray();

      int start = testCase[0] - 1;
      int end = testCase[1] - 1;

      sb.append(solve(start, end) + "\n");
    }

    System.out.println(sb);
  }

  private static int solve(int start, int end) {
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    if (end - start == 1) {
      return dp[start][end] = arr[start] == arr[end] ? 1 : 0;
    }

    if (start == end) {
      return dp[start][end] = 1;
    }

    if (arr[start] != arr[end]) {
      return dp[start][end] = 0;
    }

    dp[start][end] = solve(start +1, end - 1);
    return dp[start][end];
  }

}
