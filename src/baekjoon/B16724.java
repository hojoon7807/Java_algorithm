package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16724 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static char[][] map;
  static int[][] isVisited;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    isVisited = new int[n][m];

    int group = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (isVisited[i][j] == 0) {
          dfs(i, j, group);
          group++;
        }
      }
    }

    System.out.println(answer);
  }

  static void dfs(int r, int c, int group) {
    if (isVisited[r][c] != 0) {
      if (isVisited[r][c] == group) {
        answer++;
      }

      return;
    }

    isVisited[r][c] = group;
    char direct = map[r][c];

    int nr = r;
    int nc = c;
    switch (direct) {
      case 'U':
        nr -= 1;
        break;
      case 'D':
        nr += 1;
        break;
      case 'L':
        nc -= 1;
        break;
      case 'R':
        nc += 1;
        break;
    }

    dfs(nr, nc, group);
  }

  static void input() throws IOException {
    String[] split = br.readLine().split(" ");
    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }
  }

}
