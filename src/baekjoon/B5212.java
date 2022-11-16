package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B5212 {

  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] RC = br.readLine().split(" ");

    int R = Integer.parseInt(RC[0]);
    int C = Integer.parseInt(RC[1]);

    char[][] map = new char[R][C];
    char[][] after = new char[R][C];

    LinkedList<int[]> queue = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        char location = line.charAt(j);
        if (location == 'X') {
          queue.add(new int[]{i, j});
        }
        map[i][j] = location;
        after[i][j] = location;
      }
    }

    int minR = R, minC = C;
    int maxR = 0, maxC = 0;

    int size = queue.size();
    for (int i = 0; i < size; i++) {
      int[] node = queue.poll();
      int count = 0;
      for (int j = 0; j < 4; j++) {
        int nr = node[0] + dr[j];
        int nc = node[1] + dc[j];

        if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') {
            count ++;
          }
      }
      if (count >= 3) {
        after[node[0]][node[1]] = '.';
      } else {
        minR = Math.min(minR, node[0]);
        maxR = Math.max(maxR, node[0]);
        minC = Math.min(minC, node[1]);
        maxC = Math.max(maxC, node[1]);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = minR; i <= maxR; i++) {
      for (int j = minC; j <= maxC ; j++) {
        sb.append(after[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

}
