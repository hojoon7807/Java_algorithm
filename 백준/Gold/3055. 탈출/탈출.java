import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
  /*
  물이 불어나는 시간을 따로 배열을 두어 체크를 해놓는다
  고슴도치가 움직이는 경로를 물이 불어나는 시간과 체크하여 이동을 한다.
   */

  static int n, m;
  static String[][] map;
  static int[][] distanceWater;
  static int[][] distanceMap;
  static boolean[][] isVisited;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
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
    LinkedList<int[]> floodQ = new LinkedList<>();
    int[] end = new int[2];
    int[] start = new int[2];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        if (input[j].equals("*")) {
          floodQ.add(new int[]{i, j});
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

    bfsFlood(floodQ);
    bfsHedgeDog(start);

    int answer = distanceMap[end[0]][end[1]];

    System.out.println(answer == -1 ? "KAKTUS" : answer);
  }

  static void bfsFlood(LinkedList<int[]> q) {
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (distanceWater[nr][nc] != -1 || !map[nr][nc].equals(".")) {
          continue;
        }

        distanceWater[nr][nc] = distanceWater[cur[0]][cur[1]] + 1;
        q.add(new int[]{nr, nc});
      }
    }
  }

  static void bfsHedgeDog(int[] start) {
    LinkedList<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] recent = q.poll();
      int r = recent[0];
      int c = recent[1];

      if (map[r][c].equals("D")) {
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = recent[0] + dr[i];
        int nc = recent[1] + dc[i];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        if (distanceMap[nr][nc] != -1 || !(map[nr][nc].equals(".") || map[nr][nc].equals("D"))) {
          continue;
        }

        if ((distanceWater[nr][nc] > distanceMap[r][c] + 1) || distanceWater[nr][nc] == -1) {
          distanceMap[nr][nc] = distanceMap[r][c] + 1;
          q.add(new int[]{nr, nc});
        }
      }
    }
  }
}
