package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14500 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] arr;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

  static void solution() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dfs(i, j, -1, -1, arr[i][j], 1);
        otherShape(i,j);
      }
    }

    System.out.println(answer);
  }

  static void otherShape(int r, int c) {
    // ㅗ
    if (r - 1 >= 0 && c - 1 >= 0 && c + 1 < m) {
      int sum = arr[r][c] + arr[r - 1][c] + arr[r][c - 1] + arr[r][c + 1];
      answer = Math.max(answer, sum);
    }

    // ㅜ
    if (r + 1 < n && c - 1 >= 0 && c + 1 < m) {
      int sum = arr[r][c] + arr[r + 1][c] + arr[r][c - 1] + arr[r][c + 1];
      answer = Math.max(answer, sum);
    }

    // ㅓ
    if (r - 1 >= 0 && r + 1 < n && c - 1 >= 0) {
      int sum = arr[r][c] + arr[r - 1][c] + arr[r + 1][c] + arr[r][c - 1];
      answer = Math.max(answer, sum);
    }

    // ㅏ
    if (r - 1 >= 0 && r + 1 < n && c + 1 < m) {
      int sum = arr[r][c] + arr[r - 1][c] + arr[r + 1][c] + arr[r][c + 1];
      answer = Math.max(answer, sum);
    }

  }

  static void dfs(int r, int c, int prevR, int prevC, int value, int depth) {
    if (depth == 4) {
      answer = Math.max(answer, value);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr == prevR && nc == prevC) {
        continue;
      }

      if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
        continue;
      }

      dfs(nr, nc, r, c, value + arr[nr][nc], depth + 1);
    }
  }
}
