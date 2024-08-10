
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int r, c;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int[][] resultMap;
  static boolean[][] isVisited;
  static int WALL = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    r = Integer.parseInt(input[0]);
    c = Integer.parseInt(input[1]);

    resultMap = new int[r][c];
    isVisited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      Arrays.fill(resultMap[i], -1);
    }

    LinkedList<int[]> fireQ = new LinkedList<>();
    LinkedList<int[]> jQ = new LinkedList<>();

    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        char c = s.charAt(j);

        if (c == '#') {
          resultMap[i][j] = WALL;
        } else if (c == 'F') {
          resultMap[i][j] = 0;
          fireQ.add(new int[]{i, j, 0});
        } else if (c == 'J') {
          jQ.add(new int[]{i, j, 0});
        }
      }
    }

    while (!fireQ.isEmpty()) {
      int[] cur = fireQ.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
          continue;
        }

        if (resultMap[nr][nc] != -1) {
          continue;
        }

        resultMap[nr][nc] = cur[2] + 1;
        fireQ.add(new int[]{nr, nc, cur[2] + 1});
      }
    }

    /*
    4 4
###F
#J.#
#..#
#..#
     */

    while (!jQ.isEmpty()) {
      int[] cur = jQ.poll();

      for (int i = 0; i < 4; i++) {
        int nr = cur[0] + dr[i];
        int nc = cur[1] + dc[i];

        if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
          System.out.println(cur[2] + 1);
          return;
        }

        if (resultMap[nr][nc] == WALL ||
            (resultMap[nr][nc] != -1 && resultMap[nr][nc] <= cur[2] + 1)
            || isVisited[nr][nc]) {
          continue;
        }

        isVisited[nr][nc] = true;
        jQ.add(new int[]{nr, nc, cur[2] + 1});
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
