package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17779 {

  private static int[][] population;
  private static int N;
  private static int totalPopulation = 0;
  private static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    population = new int[N][N];

    String[] input;
    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        int value = Integer.parseInt(input[j]);
        population[i][j] = value;
        totalPopulation += value;
      }
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        for (int d1 = 1; d1 < N; d1++) {
          for (int d2 = 0; d2 < N; d2++) {
            if ((r + d1 + d2) >= N) {
              continue;
            }
            if ((c - d1) < 0 || (c + d2) >= N) {
              continue;
            }
            solve(r, c, d1, d2);
          }
        }
      }
    }
    System.out.println(answer);
  }

  private static void solve(int r, int c, int d1, int d2) {
    boolean[][] border = new boolean[N][N];
    int[] sum = new int[5];
    sum[4] = totalPopulation;

    for (int i = 0; i <= d1; i++) {
      border[r + i][c - i] = true;
      border[r + d2 + i][c + d2 - i] = true;
    }

    for (int i = 0; i <= d2; i++) {
      border[r + i][c + i] = true;
      border[r + d1 + i][c - d1 + i] = true;
    }

    // 1구역 왼쪽부터 경계선 까지
    for (int i = 0; i < r + d1; i++) {
      for (int j = 0; j <= c; j++) {
        if (border[i][j]) {
          break;
        }
        sum[0] += population[i][j];
      }
    }

    // 2구역 오른쪽에서 경계선 까지
    for (int i = 0; i <= r + d2; i++) {
      for (int j = N - 1; j > c; j--) {
        if (border[i][j]) {
          break;
        }
        sum[1] += population[i][j];
      }
    }

    // 3구역
    for (int i = r + d1; i < N; i++) {
      for (int j = 0; j < c - d1 + d2; j++) {
        if (border[i][j]) {
          break;
        }
        sum[2] += population[i][j];
      }
    }

    // 4구역 오른쪽에서 경계선 까지
    for (int i = r + d2 + 1; i < N; i++) {
      for (int j = N - 1; j >= c - d1 + d2; j--) {
        if (border[i][j]) {
          break;
        }
        sum[3] += population[i][j];
      }
    }

    // 5 구역
    for (int i = 0; i < 4; i++) {
      sum[4] -= sum[i];
    }

    Arrays.sort(sum);

    answer = Math.min(answer, sum[4] - sum[0]);
  }
}
