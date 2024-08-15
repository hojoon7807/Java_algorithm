import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] map;
  static int[][][] dp;
  static boolean[][] isVisited;
  static int[] dr = {1, 0, 0};
  static int[] dc = {0, 1, -1};

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    map = new int[n][m];
    isVisited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    dp = new int[n][m][3];
    // dp[i][j] = dp[i-1][j], dp[i][j-1], dp[i][j+1]
    // 한번 탐사한 지역은 다시 탐사하지 않는다. -> 값이 할당되어 있을때 최선의 경우가 아니면 탐사 종료
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < 3; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    System.out.println(Math.max(dfs(0, 0, 0), dfs(0, 0, 1)));
  }

  static int dfs(int r, int c, int direct) {
    if (r == n - 1 && c == m - 1) {
      return map[n - 1][m - 1];
    }

    if (dp[r][c][direct] != -1) {
      return dp[r][c][direct];
    }

    int result = -123456789;
    isVisited[r][c] = true;

    for (int i = 0; i < 3; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
        continue;
      }

      if (isVisited[nr][nc]) {
        continue;
      }

      result = Math.max(result, (dfs(nr, nc, i) + map[r][c]));
    }

    isVisited[r][c] = false;

    return dp[r][c][direct] = result;
  }
}
