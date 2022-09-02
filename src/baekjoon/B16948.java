package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B16948 {

  static int N;
  static int[] dr = {-2, -2, 0, 0, 2, 2};
  static int[] dc = {-1, 1, -2, 2, -1, 1};
  static int r1, c1;
  static int r2, c2;
  static boolean[][] isVistied;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    isVistied = new boolean[N][N];
    String[] strings = br.readLine().split(" ");

    r1 = Integer.parseInt(strings[0]);
    c1 = Integer.parseInt(strings[1]);
    r2 = Integer.parseInt(strings[2]);
    c2 = Integer.parseInt(strings[3]);
    bfs();
  }

  static void bfs() {
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(new Node(r1,c1,0));

    isVistied[r1][c1] = true;

    while (!queue.isEmpty()) {
      Node node = queue.remove();

      for (int i = 0; i < 6; i++) {
        int nr = node.r + dr[i];
        int nc = node.c + dc[i];

        if (nr < 0 || nc < 0 || nr > N-1 || nc > N-1) {
          continue;
        }

        if (nr == r2 && nc == c2) {
          System.out.println(node.count+1);
          return;
        }
        if (!isVistied[nr][nc]) {
          queue.add(new Node(nr, nc, node.count + 1));
          isVistied[nr][nc] = true;
        }
      }
    }
    System.out.println(-1);
  }

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

