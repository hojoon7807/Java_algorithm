import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};
  static int INF = 123456789;

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] map;
  static int[][] dist;
  static StringBuilder sb = new StringBuilder();
  static int n;

  /*
  테스트 케이스를 다익스트라 알고리즘으로 최소 루피를 얻는 경로를 갱신한다
   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    int testCase = 1;
    while (n != 0) {
      init();
      dijkstra();
      sb.append("Problem ").append(testCase).append(": ").append(dist[n - 1][n - 1]).append("\n");
      testCase++;
      n = Integer.parseInt(br.readLine());
    }

    System.out.println(sb);
  }

  static void init() throws IOException {
    map = new int[n][n];
    dist = new int[n][n];

    for (int[] ints : dist) {
      Arrays.fill(ints, INF);
    }

    for (int i = 0; i < n; i++) {
      map[i] = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
  }

  static void dijkstra() {
    PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.rupee));
    dist[0][0] = map[0][0];
    q.add(new Point(0, 0, map[0][0]));

    while (!q.isEmpty()) {
      Point recent = q.poll();

      if (recent.rupee > dist[recent.r][recent.c]) {
        continue;
      }
      for (int i = 0; i < 4; i++) {
        int nr = recent.r + dr[i];
        int nc = recent.c + dc[i];

        if (isRange(nr, nc)) {
          if (dist[nr][nc] > recent.rupee + map[nr][nc]) {
            dist[nr][nc] = recent.rupee + map[nr][nc];
            q.add(new Point(nr, nc, dist[nr][nc]));
          }
        }
      }
    }
  }

  static boolean isRange(int r, int c) {
    if (r >= 0 && r < n && c >= 0 && c < n) {
      return true;
    }
    return false;
  }

  static class Point {
    int r;
    int c;
    int rupee;

    public Point(int r, int c, int rupee) {
      this.r = r;
      this.c = c;
      this.rupee = rupee;
    }
  }

}
