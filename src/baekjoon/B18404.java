package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class B18404 {

  static int[][] distance;
  static int n, m;
  static int x, y;
  static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
  static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    String[] xy = br.readLine().split(" ");
    x = Integer.parseInt(xy[0]);
    y = Integer.parseInt(xy[1]);

    int[] start = new int[]{x, y};
    StringBuilder sb = new StringBuilder();

    distance = new int[n + 1][n + 1];

    for (int j = 0; j <= n; j++) {
      Arrays.fill(distance[j], -1);
    }

    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);
    distance[x][y] = 0;

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      int rx = recent[0];
      int ry = recent[1];


      for (int j = 0; j < 8; j++) {
        int nx = rx + dx[j];
        int ny = ry + dy[j];

        if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
          continue;
        }

        if (distance[nx][ny] != -1) {
          continue;
        }

        distance[nx][ny] = distance[rx][ry] + 1;
        q.add(new int[]{nx, ny});
      }
    }

    for (int i = 0; i < m; i++) {


      String[] knight = br.readLine().split(" ");

      int knightX = Integer.parseInt(knight[0]);
      int knightY = Integer.parseInt(knight[1]);

      sb.append(distance[knightX][knightY]).append(" ");
    }

    System.out.println(sb);
  }

}
