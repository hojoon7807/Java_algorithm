package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B7569 {

  static int[] dr = {1, 0, -1, 0, 0, 0};
  static int[] dc = {0, 1, 0, -1, 0, 0};
  static int[] dh = {0, 0, 0, 0, 1, -1};
  static int count = 0;

  static int m, n, h;
  static int[][][] tomato;
  static int[][][] time;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] mnh = br.readLine().split(" ");
    m = Integer.parseInt(mnh[0]);
    n = Integer.parseInt(mnh[1]);
    h = Integer.parseInt(mnh[2]);

    tomato = new int[n][m][h];
    time = new int[n][m][h];

    LinkedList<int[]> q = new LinkedList<>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        String[] input = br.readLine().split(" ");
        for (int k = 0; k < m; k++) {
          int status = Integer.parseInt(input[k]);
          if (status == 1) {
            q.add(new int[]{j, k, i});
          } else if (status == 0) {
            time[j][k][i] = -1;
          }
          tomato[j][k][i] = Integer.parseInt(input[k]);
        }
      }
    }

    if (isOk()) {
      System.out.println(0);
      return;
    }

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      for (int i = 0; i < 6; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];
        int nh = recent[2] + dh[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m || nh < 0 || nh >= h) {
          continue;
        }

        if (time[nr][nc][nh] >= 0) {
          continue;
        }

        time[nr][nc][nh] = time[recent[0]][recent[1]][recent[2]] + 1;
        q.add(new int[]{nr, nc, nh});
      }
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (time[j][k][i] == -1) {
            System.out.println(-1);
            return;
          }

          count = Math.max(count, time[j][k][i]);
        }
      }
    }

    System.out.println(count);
  }

  private static boolean isOk() {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (tomato[j][k][i] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

}
