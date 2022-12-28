package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B14466 {

  private static class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Node node = (Node) o;

      if (r != node.r) {
        return false;
      }
      return c == node.c;
    }
  }

  static int[][] map;
  static int N, K, R;
  static ArrayList<Node>[][] bridges;
  static Node[] cows;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    bridges = new ArrayList[N][N];
    cows = new Node[K];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        bridges[i][j] = new ArrayList<>();
      }
    }

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken()) - 1;
      int c1 = Integer.parseInt(st.nextToken()) - 1;
      int r2 = Integer.parseInt(st.nextToken()) - 1;
      int c2 = Integer.parseInt(st.nextToken()) - 1;

      bridges[r1][c1].add(new Node(r2, c2));
      bridges[r2][c2].add(new Node(r1, c1));
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;

      map[r][c] = i;
      cows[i] = new Node(r, c);
    }

    int count = 0;
    for (int i = 0; i < K; i++) {
      count += bfs(cows[i], i);
    }

    System.out.println(count);
  }

  private static int bfs(Node cow, int num) {
    boolean[][] isVisited = new boolean[N][N];
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(new Node(cow.r, cow.c));
    isVisited[cow.r][cow.c] = true;

    int notPair = K - 1 - num;

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = current.r + dr[i];
        int nc = current.c + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]
            && !bridges[current.r][current.c].contains(new Node(nr, nc))) {
          isVisited[nr][nc] = true;
          queue.add(new Node(nr, nc));

          if (map[nr][nc] > num) {
            notPair--;
          }
        }
      }
    }
    return notPair;
  }

}
