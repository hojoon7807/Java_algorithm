import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[][] map;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static boolean[][] isVisited;
  static int min = Integer.MAX_VALUE;
  static int emptyCount = 0;
  /*
  n*n 크기의 연구소, 연구소에서 비활성 바이러스 중 m개를 활성 상태로 변경
  활성 바이러스가 비활성 바이러스에게 가면 활성으로 변한다.
  모든 칸에 바이러스를 퍼뜨리는 최소시간을 구하자

  백트래킹 -> 바이러스 고르고 다 고르면 -> 퍼지는 시간 계산 -> 최솟값 갱신
   */

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        int v = Integer.parseInt(input[j]);
        map[i][j] = v;

        if (v == 0) {
          emptyCount++;
        }
      }
    }

    if (emptyCount == 0) {
      System.out.println(0);
    } else {
      pickVirus(0, 0);
      System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
  }

  static void pickVirus(int count, int index) {
    if (count == m) {
      spreadVirus();
      return;
    }

    for (int i = index; i < n * n; i++) {
      int r = i / n;
      int c = i % n;

      if (map[r][c] == 2) {
        map[r][c] = 3;
        pickVirus(count + 1, i + 1);
        map[r][c] = 2;
      }
    }
  }

  static void spreadVirus() {
    isVisited = new boolean[n][n];
    LinkedList<Node> q = new LinkedList<>();

    int spreadCount = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 3) {
          q.add(new Node(i, j, 0));
          isVisited[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (isRange(nr, nc)) {
          if (map[nr][nc] != 1 && !isVisited[nr][nc]) {
            q.add(new Node(nr, nc, cur.time + 1));
            isVisited[nr][nc] = true;

            if (map[nr][nc] == 0) {
              spreadCount++;
            }

            if (spreadCount == emptyCount) {
              min = Math.min(min, cur.time + 1);
              return;
            }
          }
        }
      }
    }
  }

  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 & c < n) {
      return true;
    }

    return false;
  }

  static class Node {

    int r;
    int c;
    int time;

    public Node(int r, int c, int time) {
      this.r = r;
      this.c = c;
      this.time = time;
    }
  }
}
