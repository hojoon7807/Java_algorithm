package programmers;

import java.util.LinkedList;

public class 미로탈출명령어 {

  public static void main(String[] args) {
    미로탈출명령어 m = new 미로탈출명령어();
    String solution = m.solution(2, 2, 1, 1, 2, 2, 2);
    System.out.println(solution);
  }

  static int[] dr = {1, 0, 0, -1};
  static int[] dc = {0, -1, 1, 0};
  static String[] directString = {"d", "l", "r", "u"};

  public String solution(int n, int m, int x, int y, int r, int c, int k) {
    int minMove = Math.abs(x - r) + Math.abs(y - c);
    String answer = "";
    if (minMove > k) {
      return "impossible";
    }

    LinkedList<Node> q = new LinkedList<>();
    q.add(new Node(x, y, "", 0));

    boolean[][][] isVisited = new boolean[k + 1][n + 1][m + 1];

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.r == r && cur.c == c) {
        if (cur.count == k) {
          answer = cur.path;
          return answer;
        }
      }

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        int remainMove = Math.abs(nr - r) + Math.abs(nc - c);

        if (remainMove + cur.count + 1 > k) {
          continue;
        }

        if ((k - (cur.count + remainMove + 1)) % 2 == 1) {
          continue;
        }

        if (nr < 1 || nr > n || nc < 1 || nc > m) {
          continue;
        }

        if (isVisited[cur.count + 1][nr][nc]) {
          continue;
        }

        q.add(new Node(nr, nc, cur.path + directString[i], cur.count + 1));
        break;
      }
    }

    return "impossible";
  }


  static class Node {

    int r;
    int c;
    String path;
    int count;

    public Node(int r, int c, String path, int count) {
      this.r = r;
      this.c = c;
      this.path = path;
      this.count = count;
    }
  }

}
