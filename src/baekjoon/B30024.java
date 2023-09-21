package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B30024 {

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int n, m, k;
  static int[][] arr;
  static boolean[][] isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    arr = new int[n][m];
    isVisited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }

    k = Integer.parseInt(br.readLine());
    int count = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o2[2] - o1[2]);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
          pq.add(new int[]{i, j, arr[i][j]});
          isVisited[i][j] = true;
        }
      }
    }

    while (!pq.isEmpty()) {
      int[] recent = pq.poll();
      sb.append(recent[0] + 1).append(" ").append(recent[1] + 1).append("\n");
      count++;

      if (count == k) {
        System.out.println(sb);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && !isVisited[nr][nc]) {
          isVisited[nr][nc] = true;
          pq.add(new int[]{nr, nc, arr[nr][nc]});
        }
      }
    }


  }

}
