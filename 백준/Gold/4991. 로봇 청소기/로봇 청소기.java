import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int w, h;
  static Node[] dirties;
  static char[][] map;
  static int[][] dist;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int[][] groupInfo;
  static int answer;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    while (true) {
      String[] wh = br.readLine().split(" ");
      w = Integer.parseInt(wh[0]);
      h = Integer.parseInt(wh[1]);

      if (w == 0 && h == 0) {
        break;
      }

      dirties = new Node[11];
      map = new char[h][w];
      groupInfo = new int[h][w];
      int size = 1;
      answer = Integer.MAX_VALUE;

      for (int i = 0; i < h; i++) {
        char[] cs = br.readLine().toCharArray();
        for (int j = 0; j < w; j++) {
          char c = cs[j];

          if (c == 'o') {
            dirties[0] = new Node(i, j, 0);
          }

          if (c == '*') {
            dirties[size] = new Node(i, j, 0);
            groupInfo[i][j] = size;
            size++;
          }

          map[i][j] = c;
        }
      }
      
      dist = new int[size][size];

      // 시작점에서 * 방문 가능 여부 체크 거리 갱신
      boolean flag = true;
      for (int i = 0; i < size; i++) {
        Node dirty = dirties[i];

        if (!visitDirty(dirty, size)) {
          sb.append(-1).append("\n");
          flag = false;
          break;
        }
      }

      if (flag) {
        dfs(0, size, 0, new boolean[size], 0);
        sb.append(answer).append("\n");
      }
    }

    System.out.println(sb);
  }

  static void dfs(int depth, int size, int sum, boolean[] isVisited, int idx) {
    if (depth == size) {
      answer = Math.min(sum, answer);
      return;
    }

    for (int i = 0; i < size; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        dfs(depth + 1, size, sum + dist[idx][i], isVisited, i);
        isVisited[i] = false;
      }
    }
  }

  static boolean visitDirty(Node start, int size) {
    int[][] isVisited = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        isVisited[i][j] = -1;
      }
    }

    LinkedList<Node> q = new LinkedList<>();
    q.add(start);
    isVisited[start.r][start.c] = 0;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (!canMove(nr, nc)) {
          continue;
        }

        if (isVisited[nr][nc] != -1) {
          continue;
        }

        isVisited[nr][nc] = cur.count + 1;
        q.add(new Node(nr, nc, cur.count + 1));
      }
    }

    for (int i = 0; i < size; i++) {
      Node dirty = dirties[i];

      if (isVisited[dirty.r][dirty.c] == -1) {
        return false;
      }

      int from = groupInfo[start.r][start.c];
      int to = groupInfo[dirty.r][dirty.c];

      dist[from][to] = isVisited[dirty.r][dirty.c];
    }

    return true;
  }

  static boolean canMove(int r, int c) {
    return r >= 0 && r < h && c >= 0 && c < w && map[r][c] != 'x';
  }

//  static void bfs(Node start,) {
//
//  }

  static class Node {

    int r;
    int c;
    int count;

    public Node(int r, int c, int count) {
      this.r = r;
      this.c = c;
      this.count = count;
    }
  }

}
