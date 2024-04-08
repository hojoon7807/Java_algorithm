import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static int[][] map;
  static int n, m;
  static boolean[][][] isVisited;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    map = new int[n][m];
    isVisited = new boolean[n][m][2];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }

    bfs();
  }

  static void bfs() {
    LinkedList<int[]> q = new LinkedList<>();

    q.add(new int[]{0, 0, 0});
    isVisited[0][0][0] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0];
      int c = cur[1];
      int isBroken = cur[2];

      if (r == n - 1 && c == m - 1) {
        System.out.println(map[r][c] + 1);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (map[nr][nc] == 1) {
          if (isBroken == 0 && !isVisited[nr][nc][1]) {
            isVisited[nr][nc][isBroken] = true;
            map[nr][nc] = map[r][c] + 1;
            q.add(new int[]{nr, nc, 1});
          }
        } else {
          if (!isVisited[nr][nc][isBroken]) {
            isVisited[nr][nc][isBroken] = true;
            map[nr][nc] = map[r][c] + 1;
            q.add(new int[]{nr, nc, isBroken});
          }
        }
      }
    }

    System.out.println(-1);
  }
}
