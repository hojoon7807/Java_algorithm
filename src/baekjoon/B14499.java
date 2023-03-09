package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499 {

  public static int n, m, x, y, k;
  public static int[][] map;
  public static int[] dx = {0, 0, -1, 1};
  public static int[] dy = {1, -1, 0, 0};
  public static int[] dice = {0, 0, 0, 0, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < k; i++) {
      int move = Integer.parseInt(st.nextToken()) - 1;
      x += dx[move];
      y += dy[move];
      if (x < 0 || x >= n || y < 0 || y >= m) {
        x -= dx[move];
        y -= dy[move];
        continue;
      }

      switch (move) {
        case 0:
          move_right();
          break;
        case 1:
          move_left();
          break;
        case 2:
          move_up();
          break;
        case 3:
          move_down();
          break;
      }
      if (map[x][y] == 0) {
        map[x][y] = dice[1];
      } else {
        dice[1] = map[x][y];
        map[x][y] = 0;
      }

      System.out.println(dice[0]);
    }


  }

  public static void move_right() {
    int temp = dice[0];
    dice[0] = dice[4];
    dice[4] = dice[1];
    dice[1] = dice[5];
    dice[5] = temp;

  }

  public static void move_left() {
    int temp = dice[0];
    dice[0] = dice[5];
    dice[5] = dice[1];
    dice[1] = dice[4];
    dice[4] = temp;

  }

  public static void move_up() {
    int temp = dice[0];
    dice[0] = dice[2];
    dice[2] = dice[1];
    dice[1] = dice[3];
    dice[3] = temp;

  }

  public static void move_down() {
    int temp = dice[0];
    dice[0] = dice[3];
    dice[3] = dice[1];
    dice[1] = dice[2];
    dice[2] = temp;

  }
}
