package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11049 {

  private static Matrix[] matrices;
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    dp = new int[N + 1][N + 1];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= N; j++) {
        dp[i][j] = -1;
      }
    }
    matrices = new Matrix[N + 1];

    String[] input;
    for (int i = 1; i <= N; i++) {
      input = br.readLine().split(" ");
      matrices[i] = new Matrix(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }

    System.out.println(cal(1, N));
  }

  private static int cal(int start, int end) {
    int result = Integer.MAX_VALUE;
    if (dp[start][end] != -1) {
      return dp[start][end];
    }
    // 1개
    if (start == end) {
      return 0;
    }
    // 2개일때
    if (end - start == 1) {
      return matrices[start].r * matrices[start].c * matrices[end].c;
    }

    for (int i = start; i < end; i++) {
      result = Math.min(result,
          cal(start, i) + cal(i + 1, end) + (matrices[start].r * matrices[i].c * matrices[end].c));
    }

    return dp[start][end] = result;
  }

  private static class Matrix {

    int r;
    int c;

    public Matrix(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
