package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1937 {

  static int N;
  static int[][] map;
  static int[][] dp;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dp = new int[N][N];
    map = new int[N][N];
    int max = 0;

    for (int i = 0; i < N; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(split[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        max = Math.max(dfs(i, j), max);
      }
    }
    System.out.println(max);
  }

  static int dfs(int currentR, int currentC) {
    if (dp[currentR][currentC] != 0) {
      return dp[currentR][currentC];
    }

    dp[currentR][currentC] = 1;
    for (int i = 0; i < 4; i++) {
      int nr = currentR + dr[i];
      int nc = currentC + dc[i];

      if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[currentR][currentC] < map[nr][nc]) {
        dp[currentR][currentC] = Math.max(dfs(nr,nc) + 1, dp[currentR][currentC]);
      }
    }

    return dp[currentR][currentC];
  }
}
