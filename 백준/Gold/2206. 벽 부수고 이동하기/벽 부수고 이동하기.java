import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static int[][] map;
  static int n, m;
  static int[][][] count;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    map = new int[n][m];
    count = new int[n][m][2];

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
    count[0][0][0] = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0];
      int c = cur[1];
      int isBroken = cur[2];

      if (r == n - 1 && c == m - 1) {
        System.out.println(count[r][c][isBroken]);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (count[nr][nc][isBroken] != 0) {
          continue;
        }

        if (map[nr][nc] == 0) {
          count[nr][nc][isBroken] = count[r][c][isBroken] + 1;
          q.add(new int[]{nr, nc, isBroken});
        } else if (isBroken == 0 && map[nr][nc] == 1) {
          count[nr][nc][1] = count[r][c][isBroken] + 1;
          q.add(new int[]{nr, nc, 1});
        }
      }
    }

    System.out.println(-1);
  }
}
