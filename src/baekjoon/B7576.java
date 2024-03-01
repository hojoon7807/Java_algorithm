package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class B7576 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] arr;
  static int[][] isVisited;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    for (int i = 0; i < n; i++) {
      Arrays.fill(isVisited[i], -1);
    }

    LinkedList<int[]> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1) {
          q.add(new int[]{i, j});
          isVisited[i][j] = 0;
        } else if (arr[i][j] == -1) {
          isVisited[i][j] = 0;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (isVisited[nr][nc] != -1) {
          continue;
        }

        q.add(new int[]{nr, nc});
        isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
      }
    }
    int answer = -1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (isVisited[i][j] == -1) {
          System.out.println(-1);
          return;
        } else {
          answer = Math.max(answer, isVisited[i][j]);
        }
      }
    }

    System.out.println(answer);
  }

  static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    m = Integer.parseInt(input[0]);
    n = Integer.parseInt(input[1]);

    arr = new int[n][m];
    isVisited = new int[n][m];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }
  }

}
