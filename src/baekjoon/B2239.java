package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] map = new int[9][9];
  static boolean[][] rowCheck = new boolean[9][10];
  static boolean[][] colCheck = new boolean[9][10];
  static boolean[][] divideCheck = new boolean[9][10];

  /*
   0 1 2    0,0 2,2    0,3 2,5  0,6 2,8  i/3*3 + j/3
   3 4 5    3,0 5,2    3,3 5,5  3,6 5,8
   6 7 8    6,0 8,2    6,3 8,5  6,6 8,8
   */

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  private static void solution() {
    dfs(0, 0);
  }

  private static void dfs(int r, int c) {
    if (r == 9) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(map[i][j]);
        }
        sb.append("\n");
      }

      System.out.println(sb);
      System.exit(0);
    }

    if (map[r][c] == 0) {
      for (int i = 1; i <= 9; i++) {
        if (isEnable(r, c, i)) {
          rowCheck[r][i] = true;
          colCheck[c][i] = true;
          divideCheck[encode(r, c)][i] = true;
          map[r][c] = i;

          if (c == 8) {
            dfs(r + 1, 0);
          } else {
            dfs(r, c + 1);
          }

          rowCheck[r][i] = false;
          colCheck[c][i] = false;
          divideCheck[encode(r, c)][i] = false;
          map[r][c] = 0;
        }
      }
    } else {

      if (c == 8) {
        dfs(r + 1, 0);
      } else {
        dfs(r, c + 1);
      }
    }

  }

  static boolean isEnable(int r, int c, int value) {
    if (!rowCheck[r][value] && !colCheck[c][value] && !divideCheck[encode(r, c)][value]) {
      return true;
    }

    return false;
  }

  private static void input() throws IOException {
    for (int i = 0; i < 9; i++) {
      char[] input = br.readLine().toCharArray();
      for (int j = 0; j < 9; j++) {
        int value = input[j] - '0';
        map[i][j] = value;
        if (value != 0) {
          rowCheck[i][value] = true;
          colCheck[j][value] = true;
          divideCheck[encode(i, j)][value] = true;
        }

      }
    }
  }

  static int encode(int r, int c) {
    return r / 3 * 3 + c / 3;
  }

}
