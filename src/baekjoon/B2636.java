package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B2636 {

  static int[][] arr;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    arr = new int[n][m];
    int cheeseCount = 0;

    ArrayList<Node> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        int value = Integer.parseInt(input[j]);

        if (value == 1) {
          cheeseCount++;
        }
        arr[i][j] = value;
      }
    }

    int time = 0;

    while (true) {
      makeAir();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] == 1) {
            for (int k = 0; k < 4; k++) {
              int nr = i + dr[k];
              int nc = j + dc[k];

              if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == -1) {
                list.add(new Node(i, j));
                break;
              }
            }
          }
        }
      }

      if (list.size() == cheeseCount) {
        System.out.println(time + 1 + "\n" + list.size());
        return;
      }

      for (Node node : list) {
        arr[node.r][node.c] = -1;
      }

      cheeseCount -= list.size();
      list.clear();
      time++;
    }
  }

  private static void makeAir() {
    LinkedList<Node> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[n][m];
    isVisited[0][0] = true;
    arr[0][0] = -1;
    q.add(new Node(0, 0));

    while (!q.isEmpty()) {
      Node poll = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = poll.r + dr[i];
        int nc = poll.c + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] != 1 && !isVisited[nr][nc]) {
          arr[nr][nc] = -1;
          isVisited[nr][nc] = true;
          q.add(new Node(nr, nc));
        }
      }
    }
  }

  private static class Node {

    int r;
    int c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

}
