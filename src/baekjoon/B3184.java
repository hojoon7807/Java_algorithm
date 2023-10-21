package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class B3184 {

  static String[][] map;
  static boolean[][] isVisited;
  static int r,c;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int sheep = 0, wolf = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] rc = br.readLine().split(" ");
    r = Integer.parseInt(rc[0]);
    c = Integer.parseInt(rc[1]);

    map = new String[r][c];
    isVisited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < c; j++) {
        map[i][j] = input[j];
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (!map[i][j].equals("#") && !isVisited[i][j]) {
          isVisited[i][j] = true;
          ArrayList<int[]> list = new ArrayList<>();
          int[] start = new int[]{i, j};
          list.add(start);
          makeGroup(start, list);
        }
      }
    }

    System.out.println(sheep + " " + wolf);

  }

  static void makeGroup(int[] start, ArrayList<int[]> list) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] recent = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
          continue;
        }

        if (map[nr][nc].equals("#") || isVisited[nr][nc]) {
          continue;
        }

        isVisited[nr][nc] = true;
        int[] next = {nr, nc};
        list.add(next);
        q.add(next);
      }
    }

    int sheepCount = 0;
    int wolfCount = 0;

    for (int[] node : list) {
      int r = node[0];
      int c = node[1];

      if (map[r][c].equals("o")) {
        sheepCount ++;
      } else if (map[r][c].equals("v")) {
        wolfCount ++;
      }
    }

    if (sheepCount > wolfCount) {
      sheep += sheepCount;
    } else {
      wolf += wolfCount;
    }
  }

}
