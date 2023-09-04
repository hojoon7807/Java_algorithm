package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2206 {

  static int[][] map;
  static int n, m;
  static int[][][] isVisited;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    map = new int[n][m];
    isVisited = new int[n][m][2];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    bfs();
  }

  static void bfs() {
    LinkedList<int[]> q = new LinkedList<>();

    q.add(new int[]{0, 0, 0, 1});

    while (!q.isEmpty()) {
      int[] poll = q.poll();
      int isBroken = poll[2];

      if (poll[0] == n - 1 && poll[1] == m - 1) {
        System.out.println(poll[3]);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nr = poll[0] + dr[i];
        int nc = poll[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }
        if (map[nr][nc] == 1 && isBroken == 0 && isVisited[nr][nc][1] == 0) {
          q.add(new int[]{nr, nc, 1, poll[3] + 1});
          isVisited[nr][nc][1] = 1;
        } else if (map[nr][nc] == 0 && isVisited[nr][nc][isBroken] == 0) {
          q.add(new int[]{nr, nc, isBroken, poll[3] + 1});
          isVisited[nr][nc][isBroken] = 1;
        }
      }
    }

    System.out.println(-1);
    return;
  }
}
