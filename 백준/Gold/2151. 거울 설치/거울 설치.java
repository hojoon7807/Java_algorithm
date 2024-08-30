import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static char[][] map;
  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};
  static boolean[][][] isVisited;
  static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    n = Integer.parseInt(br.readLine());
    map = new char[n][n];

    isVisited = new boolean[n][n][4];
    Node start = null;
    boolean flag = false;

    for (int i = 0; i < n; i++) {
      char[] cs = br.readLine().toCharArray();

      for (int j = 0; j < n; j++) {
        char c = cs[j];

        if (c == '#') {
          if (!flag) {
            flag = true;
            start = new Node(i, j, 0, 0);
            map[i][j] = '*';
          } else {
            map[i][j] = c;
          }
        } else {
          map[i][j] = c;
        }
      }
    }

    setDirect(start);
    bfs();
    System.out.println(answer);
  }

  static void setDirect(Node start) {
    for (int i = 0; i < 4; i++) {
      int nr = start.r + dr[i];
      int nc = start.c + dc[i];

      if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == '*') {
        continue;
      }

      pq.add(new Node(nr, nc, i, 0));
      isVisited[nr][nc][i] = true;
      isVisited[start.r][start.c][i] = true;
    }
  }

  static void bfs() {
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      //System.out.println("이동경로: " + cur.r + " " + cur.c + " " + cur.dir + " " + cur.count);
      if (map[cur.r][cur.c] == '#') {
        answer = Math.min(answer, cur.count);
        continue;
      }

      // 현재 위치에 거울이 있다면 방향 바꿔주기
      // S,N,W,E
      if (map[cur.r][cur.c] == '!') {
        if (cur.dir == 0 || cur.dir == 1) {
          for (int d = 2; d < 4; d++) {
            rotate(cur, d);
          }
        } else {
          for (int d = 0; d < 2; d++) {
            rotate(cur, d);
          }
        }
      }

      // 다음 방향 ( count X, 쭉)
      int nr = cur.r + dr[cur.dir];
      int nc = cur.c + dc[cur.dir];

      // 벽이거나 범위를 벗어나면 continue
      if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == '*') {
        continue;
      }

//      // 방문한적이 있으면 continue
//      if (isVisited[nr][nc][cur.dir]) {
//        continue;
//      }

      // 해당방향 이동 카운트 증가 X
      pq.add(new Node(nr, nc, cur.dir, cur.count));
      isVisited[nr][nc][cur.dir] = true;
    }
  }

  private static void rotate(Node cur, int d) {
    int rR = cur.r + dr[d];
    int rC = cur.c + dc[d];

    if (rR < 0 || rR >= n || rC < 0 || rC >= n || map[rR][rC] == '*') {
      return;
    }

    if (!isVisited[rR][rC][d]) {
      pq.add(new Node(rR, rC, d, cur.count + 1));
      isVisited[rR][rC][d] = true;
    }
  }

  static class Node {

    int r;
    int c;
    int dir;
    int count;

    public Node(int r, int c, int dir, int count) {
      this.r = r;
      this.c = c;
      this.dir = dir;
      this.count = count;
    }
  }
}
