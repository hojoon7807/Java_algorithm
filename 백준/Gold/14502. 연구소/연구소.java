
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static int n, m;
  static int[][] map;
  static int max = Integer.MIN_VALUE;
  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] shape = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        int status = Integer.parseInt(shape[j]);
        map[i][j] = status;
      }
    }

    dfs(0,0);
    System.out.println(max);
  }

  private static void dfs(int count, int start) {
    if (count == 3) {
      bfs();
      return;
    }
    for (int i = start; i < n * m; i++) {
      int r = i / m;
      int c = i % m;

      if (map[r][c] == 0) {
        map[r][c] = 1;
        dfs(count + 1, i + 1);
        map[r][c] = 0;
      }
    }

  }

  private static void bfs() {
    LinkedList<Node> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 2) {
          q.add(new Node(i, j));
          isVisited[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      Node poll = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = poll.r + dr[i];
        int nc = poll.c + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && !isVisited[nr][nc]
            && map[nr][nc] == 0) {
          isVisited[nr][nc] = true;
          map[nr][nc] = 3;
          q.add(new Node(nr, nc));
        }
      }
    }

    int safetyZone = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          safetyZone++;
        } else if (map[i][j] == 3) {
          map[i][j] = 0;
        }
      }
    }

    max = Math.max(max, safetyZone);

  }

  static class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
