package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2186 {

  static int N, M, K;
  static char[][] map;
  static int[][][] dp;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static String word;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    word = br.readLine();
    dp = new int[N][M][word.length()];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == word.charAt(0)) {
          answer += dfs(i, j, 0);
        }
      }
    }
    System.out.println(answer);
  }

  private static int dfs(int r, int c, int index) {
    if (index == word.length() - 1) {
      return dp[r][c][index] = 1;
    }

    if (dp[r][c][index] != -1) {
      return dp[r][c][index];
    }

    dp[r][c][index] = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= K; j++) {
        int nr = r + dr[i] * j;
        int nc = c + dc[i] * j;

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == word.charAt(index + 1)) {
          dp[r][c][index] += dfs(nr, nc, index + 1);
        }
      }
    }
    return dp[r][c][index];
  }
}
