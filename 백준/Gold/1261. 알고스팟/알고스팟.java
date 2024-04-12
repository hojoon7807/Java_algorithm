import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static char[][] map;
  static int[][] dist;
  static int INF = 123456789;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  /*
  벽을 최소 몇개 부수고 (0,0) -> (n-1, m-1) 로 이동 가능?
  
  이동하면서 사용하는 벽의 개수로 최단거리 알고리즘 사용가능
  
  우선순위 큐를 사용한 BFS로도 풀릴 듯?

   */
  public static void main(String[] args) throws IOException {
    String[] mn = br.readLine().split(" ");
    m = Integer.parseInt(mn[0]);
    n = Integer.parseInt(mn[1]);

    map = new char[n][m];
    dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], INF);
    }

    dijkstra();

    System.out.println(dist[n - 1][m - 1]);
  }

  static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.wall));
    dist[0][0] = 0;
    pq.add(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.wall > dist[cur.r][cur.c]) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (isRange(nr, nc)) {
          int next = map[nr][nc] - '0';
          if (dist[nr][nc] > next + cur.wall) {
            dist[nr][nc] = next + cur.wall;
            pq.add(new Node(nr, nc, dist[nr][nc]));
          }
        }
      }
    }

  }

  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < m) {
      return true;
    }

    return false;
  }

  static class Node {

    int r;
    int c;
    int wall;

    public Node(int r, int c, int wall) {
      this.r = r;
      this.c = c;
      this.wall = wall;
    }
  }
}
