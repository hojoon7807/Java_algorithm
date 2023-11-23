package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2468 {

  static int n;
  static int[][] arr;
  static boolean[][] isVisited;
  static int answer = 0;
  static int max = 0;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int height = Integer.parseInt(input[j]);
        max = Math.max(max, height);
        arr[i][j] = height;
      }
    }

    for (int i = max; i >= 0; i--) {
      int count = 0;
      isVisited = new boolean[n][n];

      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (!isVisited[j][k] && arr[j][k] > i) {
            count++;
            bfs(i, j, k);
          }
        }
      }
      answer = Math.max(answer, count);
    }

    System.out.println(answer);

  }

  static void bfs(int height, int r, int c) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    isVisited[r][c] = true;

    while (!q.isEmpty()) {
      int[] poll = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = poll[0] + dr[i];
        int nc = poll[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
          continue;
        }

        if (isVisited[nr][nc] || arr[nr][nc] <= height) {
          continue;
        }

        isVisited[nr][nc] = true;
        q.add(new int[]{nr, nc});
      }
    }
  }

}
