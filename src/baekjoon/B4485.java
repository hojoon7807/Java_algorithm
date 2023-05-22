package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B4485 {

  private static int[] dr = {1, -1, 0, 0};
  private static int[] dc = {0, 0, 1, -1};
  private static int INF = 123456789;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] map;
    int[][] dist;
    StringBuilder sb = new StringBuilder();
    int testCase = 1;
    while (n != 0) {
      map = new int[n][n];
      dist = new int[n][n];
      for (int[] ints : dist) {
        Arrays.fill(ints, INF);
      }
      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(input[j]);
        }
      }

      PriorityQueue<Point> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.rupee)));
      dist[0][0] = map[0][0];
      q.add(new Point(0, 0, map[0][0]));

      while (!q.isEmpty()) {
        Point recent = q.poll();

        if (recent.rupee > dist[recent.r][recent.c]) {
          continue;
        }
        for (int i = 0; i < 4; i++) {
          int nr = recent.r + dr[i];
          int nc = recent.c + dc[i];

          if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
            if (dist[nr][nc] > recent.rupee + map[nr][nc]) {
              dist[nr][nc] = recent.rupee + map[nr][nc];
              q.add(new Point(nr, nc, dist[nr][nc]));
            }
          }
        }
      }
      sb.append("Problem " + testCase + ": " + dist[n - 1][n - 1] + "\n");

      testCase++;
      n = Integer.parseInt(br.readLine());
    }
    System.out.println(sb);
  }

  private static class Point {

    int r;
    int c;
    int rupee;

    public Point(int r, int c, int rupee) {
      this.r = r;
      this.c = c;
      this.rupee = rupee;
    }
  }

}
