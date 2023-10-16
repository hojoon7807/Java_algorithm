package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B4963 {

  static int w, h;
  static int[][] map;
  static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
  static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
  static boolean[][] isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] wh = br.readLine().split(" ");
    w = Integer.parseInt(wh[0]);
    h = Integer.parseInt(wh[1]);

    StringBuilder sb = new StringBuilder();

    while (w != 0 && h != 0) {
      map = new int[h][w];
      isVisited = new boolean[h][w];

      int answer = 0;
      for (int i = 0; i < h; i++) {
        String[] input = br.readLine().split(" ");
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(input[j]);
        }
      }

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && !isVisited[i][j]) {
            answer ++;
            makeLand(new int[]{i, j});
          }
        }
      }

      sb.append(answer).append("\n");

      wh = br.readLine().split(" ");
      w = Integer.parseInt(wh[0]);
      h = Integer.parseInt(wh[1]);
    }

    System.out.println(sb);
  }

  static void makeLand(int[] start) {
    isVisited[start[0]][start[1]] = true;
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      for (int i = 0; i < 8; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
          continue;
        }

        if (map[nr][nc] == 0 || isVisited[nr][nc]) {
          continue;
        }

        isVisited[nr][nc] = true;
        q.add(new int[]{nr, nc});
      }
    }
  }
}
