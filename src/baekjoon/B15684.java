package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15684 {
  static int n,m,h;
  static int[][] arr;
  static boolean flag;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nmh = br.readLine().split(" ");
    n = Integer.parseInt(nmh[0]);
    m = Integer.parseInt(nmh[1]);
    h = Integer.parseInt(nmh[2]);

    arr = new int[h+1][n+1];

    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);

      arr[a][b] = 1;
      arr[a][b+1] = 2;
    }

    for (int i = 0; i <= 3; i++) {
      dfs(0, i);
      if (flag) {
        System.out.println(i);
        return;
      }
    }

    System.out.println(-1);
  }

  static void dfs(int depth, int count) {
    if (flag) {
      return;
    }
    if (depth == count) {
      if (move()) {
        flag = true;
      }
      return;
    }
    for (int i = 1; i <= h; i++) {
      for (int j = 1; j < n; j++) {
        if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
          arr[i][j] = 1;
          arr[i][j + 1] = 2;
          dfs(depth+1, count);
          arr[i][j] = 0;
          arr[i][j + 1] = 0;
        }
      }
    }
  }

  static boolean move() {
    for (int i = 1; i <=n ; i++) {
      int col = i;
      for (int j = 1; j <= h; j++) {
        if (arr[j][col] == 1) {
          col++;
        } else if (arr[j][col] == 2) {
          col--;
        }
      }
      if (col != i) {
        return false;
      }
    }
    return true;
  }
}
