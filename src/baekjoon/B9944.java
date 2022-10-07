package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9944 {

  static int min = Integer.MAX_VALUE;
  static int n, m;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int size;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int caseNum = 1;
    String nm = "";
    while ((nm=br.readLine()) != null && !nm.isEmpty()) {
      //String[] nm = br.readLine().split(" ");

      min = Integer.MAX_VALUE;
      n = Integer.parseInt(nm.split(" ")[0]);
      m = Integer.parseInt(nm.split(" ")[1]);
      boolean[][] board = new boolean[n][m];

      ArrayList<int[]> locations = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        String[] s = br.readLine().split("");
        for (int j = 0; j < m; j++) {
          if (s[j].equals("*")) {
            board[i][j] = true;
          } else {
            locations.add(new int[]{i, j});
          }
        }
      }


      size = locations.size();

      for (int[] location : locations) {
        board[location[0]][location[1]] = true;
        move(location, board, 0,1);
        board[location[0]][location[1]] = false;
      }

      min = min==Integer.MAX_VALUE? -1 : min;

      System.out.println("Case "+ caseNum++ +": "+min);
    }
  }

  static void move(int[] location, boolean[][] map, int count, int fill) {
    if (fill == size) {
      min = Math.min(min, count);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int move = 0;
      int r = location[0];
      int c = location[1];
      int nr;
      int nc;

      while (true) {
        nr = r + dr[i];
        nc = c + dc[i];
        if (!canMove(nr, nc) || map[nr][nc]) {
          break;
        }
        map[nr][nc] = true;
        move++;
        r = nr;
        c = nc;
      }

      if(r == location[0] && c == location[1]) continue;
      move(new int[]{r,c}, map, count+1, fill+move);

      for(int j = 0 ; j < move ; j++) {
        map[r][c] = false;
        r = r - dr[i];
        c = c - dc[i];
      }

    }
  }

  static boolean canMove(int r, int c) {
    if (r >= n || c >= m || r < 0 || c < 0) {
      return false;
    }
    return true;
  }

}
