package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class B3055 {

  static int n, m;
  static String[][] map;
  static int[][] distanceWater;
  static int[][] distanceMap;
  static boolean[][] isVisited;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");

    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    map = new String[n][m];
    distanceWater = new int[n][m];
    distanceMap = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(distanceWater[i], -1);
    }

    for (int i = 0; i < n; i++) {
      Arrays.fill(distanceMap[i], -1);
    }
    isVisited = new boolean[n][m];
    ArrayList<int[]> floodList = new ArrayList<>();
    int[] end = new int[2];
    int[] start = new int[2];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        if (input[j].equals("*")) {
          floodList.add(new int[]{i, j});
          distanceWater[i][j] = 0;
        } else if (input[j].equals("S")) {
          start = new int[]{i, j};
          distanceMap[i][j] = 0;
        } else if (input[j].equals("D")) {
          end = new int[]{i, j};
        }
        map[i][j] = input[j];
      }
    }

    bfsFlood(floodList);
    bfsHedgeDog(start, end);
    int answer = distanceMap[end[0]][end[1]];
    System.out.println(answer == -1 ? "KAKTUS" : answer);
  }

  static void bfsFlood(ArrayList<int[]> floodList) {
    LinkedList<int[]> q = new LinkedList<>();
    for (int[] flood : floodList) {
      q.add(flood);
    }

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && distanceWater[nr][nc] == -1
            && map[nr][nc].equals(".")) {
          distanceWater[nr][nc] = distanceWater[recent[0]][recent[1]] + 1;
          q.add(new int[]{nr, nc});
        }
      }
    }
  }

  static void bfsHedgeDog(int[] start, int[] end) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      int r = recent[0];
      int c = recent[1];

      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if ((nr >= 0 && nr < n && nc >= 0 && nc < m && distanceMap[nr][nc] == -1)
            && (map[nr][nc].equals(".") || map[nr][nc].equals("D"))) {
          if ((distanceWater[nr][nc] > distanceMap[r][c] + 1) || distanceWater[nr][nc] == -1) {
            distanceMap[nr][nc] = distanceMap[r][c] + 1;
            q.add(new int[]{nr, nc});
          }
        }
      }
    }
  }

}
