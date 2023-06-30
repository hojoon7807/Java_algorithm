package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B2638 {

  static int n, m;
  static int[][] map;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);

    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      split = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(split[j]);
      }
    }
    int time = 0;

    ArrayList<int[]> meltedCheese = new ArrayList<>();

    while (true) {
      meltedCheese.clear();
      fillExternalAir();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] == 1) {
            if(isPossible(i,j)) {
              meltedCheese.add(new int[]{i, j});
            }
          }

        }
      }

      if (meltedCheese.size() == 0) {
        System.out.println(time);
        return;
      }

      time++;

      for (int[] ints : meltedCheese) {
        map[ints[0]][ints[1]] = -1;
      }
    }
  }

  private static boolean isPossible(int r, int c) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      int nr = dr[i] + r;
      int nc = dc[i] + c;

      if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == -1) {
        count++;
      }
    }

    return count >= 2 ? true : false;
  }

  static void fillExternalAir() {
    LinkedList<int[]> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[n][m];
    q.add(new int[]{0, 0});
    isVisited[0][0] = true;
    map[0][0] = -1;

    while (!q.isEmpty()) {
      int[] poll = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = poll[0] + dr[i];
        int nc = poll[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m || isVisited[nr][nc] || map[nr][nc] == 1) {
          continue;
        }

        q.add(new int[]{nr, nc});
        isVisited[nr][nc] = true;
        map[nr][nc] = -1;
      }
    }
  }

}
