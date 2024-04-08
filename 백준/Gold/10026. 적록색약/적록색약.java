import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  /*
  적록색약과 일반인 2가지 경우를 BFS로 탐색하기
   */

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static char[][] arr;
  static boolean[][] isVisited;

  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new char[n][n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    int normalCount = 0;
    isVisited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          normalCount++;
          normal(i, j, arr[i][j]);
        }
      }
    }

    int redGreenCount = 0;
    isVisited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j]) {
          redGreenCount++;
          redGreen(i, j, arr[i][j]);
        }
      }
    }

    System.out.println(normalCount + " " + redGreenCount);
  }

  static void normal(int r, int c, char color) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    isVisited[r][c] = true;

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

        isVisited[nr][nc] = true;
        q.add(new int[]{nr, nc});
      }
    }
  }

  static void redGreen(int r, int c, char color) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    isVisited[r][c] = true;

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

        if (color == 'R' || color == 'G') {
          if (arr[nr][nc] == 'B') {
            continue;
          }
        } else {
          if (arr[nr][nc] != 'B') {
            continue;
          }
        }

        isVisited[nr][nc] = true;
        q.add(new int[]{nr, nc});
      }
    }
  }


}
