package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B1012 {

  static int n, m, k;
  static int t;
  static int[][] arr;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (t > 0) {
      String[] mnk = br.readLine().split(" ");
      m = Integer.parseInt(mnk[0]);
      n = Integer.parseInt(mnk[1]);
      k = Integer.parseInt(mnk[2]);

      arr = new int[n][m];

      for (int i = 0; i < k; i++) {
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        arr[y][x] = -1;
      }

      int groupNum = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] == -1) {
            groupNum++;
            arr[i][j] = groupNum;
            makeGroup(groupNum, new int[]{i, j});
          }
        }
      }

      sb.append(groupNum).append("\n");
      t--;
    }

    System.out.println(sb);
  }

  static void makeGroup(int groupNum, int[] start) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);
    while (!q.isEmpty()) {
      int[] recent = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (arr[nr][nc] != -1) {
          continue;
        }

        arr[nr][nc] = groupNum;
        q.add(new int[]{nr, nc});
      }
    }
  }

}
