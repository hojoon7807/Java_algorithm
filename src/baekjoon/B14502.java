package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B14502 {

  static int n, m;
  static int[][] map;
  static int max = Integer.MIN_VALUE;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] shape = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(shape[j]);
      }
    }

    dfs(0);
    System.out.println(max);
  }

  static void dfs(int depth) {
    if (depth == 3) {
      bfs();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          dfs(depth + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  static void bfs() {
    LinkedList<Node> q = new LinkedList<>();
    int[][] resultMap = new int[n][m];

    for (int i = 0; i < n; i++) {
      resultMap[i] = map[i].clone();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (resultMap[i][j] == 2) {
          q.add(new Node(i, j));
        }
      }
    }

    while (!q.isEmpty()) {
      Node now = q.remove();
      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (resultMap[nx][ny] == 0) {
            resultMap[nx][ny] = 2;
            q.add(new Node(nx, ny));
          }
        }
      }
    }
    cal(resultMap);
  }

  static void cal(int[][] result) {
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (result[i][j] == 0) {
          count++;
        }
      }
    }
    max = Math.max(count, max);
  }

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
