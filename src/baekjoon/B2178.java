package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2178 {

  static int n, m;
  static int[][] arr;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static boolean[][] isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    arr = new int[n][m];
    isVisited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }

    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0, 1});
    isVisited[0][0] = true;

    while (!q.isEmpty()) {
      int[] recent = q.poll();

      if (recent[0] == n - 1 && recent[1] == m - 1) {
        System.out.println(recent[2]);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == 1 && !isVisited[nr][nc]) {
          isVisited[nr][nc] = true;
          q.add(new int[]{nr, nc, recent[2] + 1});
        }
      }
    }
  }

}
