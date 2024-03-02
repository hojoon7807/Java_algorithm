package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B10026 {

  /*
  5
  RRRBB
  GGBBB
  BBBRR
  BBRRR
  RRRRR
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static char[][] arr;
  static boolean[][] isVisited;

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    isVisited = new boolean[n][n];
    int normalCount = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          normal(i,j, arr[i][j]);
          normalCount++;
        }
      }
    }

    isVisited = new boolean[n][n];
    int redGreenCount = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          redGreen(i,j, arr[i][j]);
          redGreenCount++;
        }
      }
    }

    System.out.println(normalCount + " " + redGreenCount);
  }

  static void redGreen(int r, int c, char color) {
    LinkedList<int[]> q = new LinkedList<>();
    isVisited[r][c] = true;
    q.add(new int[]{r, c});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
          continue;
        }

        if (isVisited[nr][nc]) {
          continue;
        }

        if (color == 'B') {
          if (arr[nr][nc] != color) {
            continue;
          }
        } else {
          if (arr[nr][nc] == 'B') {
            continue;
          }
        }

        q.add(new int[]{nr, nc});
        isVisited[nr][nc] = true;
      }
    }
  }

  static void normal(int r, int c, char color) {
    LinkedList<int[]> q = new LinkedList<>();
    isVisited[r][c] = true;
    q.add(new int[]{r, c});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
          continue;
        }

        if (isVisited[nr][nc] || arr[nr][nc] != color) {
          continue;
        }

        q.add(new int[]{nr, nc});
        isVisited[nr][nc] = true;
      }
    }
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new char[n][n];

    for (int i = 0; i < n; i++) {
      char[] charArray = br.readLine().toCharArray();
      arr[i] = charArray;
    }
  }

}
