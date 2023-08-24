package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1987 {
  static int R,C;
  static char[][] arr;
  static boolean[] isVisited = new boolean[26];
  static int max = 1;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    R = Integer.parseInt(input[0]);
    C = Integer.parseInt(input[1]);

    arr = new char[R][C];

    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        arr[i][j] = row.charAt(j);
      }
    }

    isVisited[arr[0][0] - 'A'] = true;
    dfs(0, 0, 1);

    System.out.println(max);
  }

  private static void dfs(int r, int c, int count) {
    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
        char alpha = arr[nr][nc];
        int index = alpha - 'A';

        if (!isVisited[index]) {
          isVisited[index] = true;
          dfs(nr, nc, count + 1);
          isVisited[index] = false;
        } else {
          max = Math.max(max, count);
        }
      }
    }
  }
}
