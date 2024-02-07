package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] map;
  static int N;
  static int[][][] dp;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void solution() {
    dp = new int[N][N][3];

    int answer = dfs(0, 1, Direct.RIGHT);
    System.out.println(answer);
  }

  static int dfs(int row, int col, Direct direct) {
    if (row < 0 || row >= N || col < 0 || col >= N) {
      return 0;
    }

    if (direct.equals(Direct.RIGHT_DOWN)) {
      if (map[row - 1][col] == 1 || map[row][col - 1] == 1) {
        return 0;
      }
    }

    if (map[row][col] == 1) {
      return 0;
    }

    if (row == N - 1 && col == N - 1) {
      return 1;
    }

    if (dp[row][col][direct.index] != 0) {
      return dp[row][col][direct.index];
    }

    switch (direct) {
      case RIGHT:
        dp[row][col][direct.index] += dfs(row, col + 1, Direct.RIGHT) + dfs(row + 1, col + 1, Direct.RIGHT_DOWN);
        break;
      case RIGHT_DOWN:
        dp[row][col][direct.index] += dfs(row, col + 1, Direct.RIGHT) + dfs(row + 1, col + 1, Direct.RIGHT_DOWN) + dfs(row+1, col, Direct.DOWN);
        break;
      case DOWN:
        dp[row][col][direct.index] += dfs(row + 1, col + 1, Direct.RIGHT_DOWN) + dfs(row+1, col, Direct.DOWN);
        break;
    }

    return dp[row][col][direct.index];
  }

  static enum Direct {
    RIGHT(0),
    DOWN(1),
    RIGHT_DOWN(2);

    int index;

    public int getIndex() {
      return index;
    }

    Direct(int index) {
      this.index = index;
    }
  }


}
