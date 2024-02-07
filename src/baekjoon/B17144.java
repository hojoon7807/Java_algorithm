package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B17144 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] map;
  static int R, C, T;
  static int[] dr = {1, 0, -1, 0};
  static int[] dc = {0, 1, 0, -1};
  static int upAir;
  static int downAir;

  static ArrayList<Dust> dusts = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[R][C];

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  static void solution() {
    findAirCleaner();
    for (int t = 0; t < T; t++) {
      addDust();
      spread();
      runUpAirCleaner();
      runDownAirCleaner();
      dusts.clear();
    }

    int answer = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] > 0) {
          answer += map[i][j];
        }
      }
    }

    System.out.println(answer);
  }

  static void runUpAirCleaner() {
    //왼쪽
    for (int i = upAir - 1; i > 0; i--) {
      map[i][0] = map[i - 1][0];
    }

    //위
    for (int i = 0; i < C - 1; i++) {
      map[0][i] = map[0][i + 1];
    }

    // 오른
    for (int i = 0; i < upAir; i++) {
      map[i][C - 1] = map[i + 1][C - 1];
    }

    // 아래
    for (int i = C - 1; i > 1; i--) {
      map[upAir][i] = map[upAir][i - 1];
    }

    map[upAir][1] = 0;
  }

  static void runDownAirCleaner() {
    //왼쪽
    for (int i = downAir + 1; i < R - 1; i++) {
      map[i][0] = map[i + 1][0];
    }
    // 아래
    for (int i = 0; i < C - 1; i++) {
      map[R - 1][i] = map[R - 1][i + 1];
    }

    // 오른
    for (int i = R - 1; i > downAir; i--) {
      map[i][C - 1] = map[i - 1][C - 1];
    }

    //위
    for (int i = C - 1; i > 1; i--) {
      map[downAir][i] = map[downAir][i - 1];
    }
    map[downAir][1] = 0;
  }

  static void findAirCleaner() {
    for (int i = 0; i < R; i++) {
      if (map[i][0] == -1) {
        upAir = i;
        downAir = i + 1;
        return;
      }
    }
  }

  static void spread() {
    for (Dust dust : dusts) {
      int speardAmount = dust.amount / 5;
      for (int i = 0; i < 4; i++) {
        int nr = dust.r + dr[i];
        int nc = dust.c + dc[i];

        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
          continue;
        }

        if (map[nr][nc] == -1) {
          continue;
        }

        map[nr][nc] += speardAmount;
        map[dust.r][dust.c] -= speardAmount;
      }
    }
  }

  static void addDust() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int value = map[i][j];

        if (value > 0) {
          dusts.add(new Dust(i, j, value));
        }
      }
    }
  }

  static class Dust {

    int r;
    int c;
    int amount;

    public Dust(int r, int c, int amount) {
      this.r = r;
      this.c = c;
      this.amount = amount;
    }
  }

}
