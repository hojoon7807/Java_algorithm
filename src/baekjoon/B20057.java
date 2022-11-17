package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B20057 {

  static int N;
  static int[][] map;

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {-1, 0, 1, 0};
  static int[] moveCount = {1, 1, 2, 2};

  static int[][] spreadDr = {{-1, 1, -2, 2, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
      {1, -1, 2, -2, 1, -1, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
  static int[][] spreadDc = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, 2, -1, 1, -1, 1, 0},
      {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, -2, 1, -1, 1, -1, 0}};
  static int[] ratio = {1, 1, 2, 2, 7, 7, 10, 10, 5};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      map[i] = input;
    }
    System.out.println(move(N/2,N/2));
  }

  static int move(int r, int c){
    int totalOutSand = 0;
    int recentR = r;
    int recentC = c;

    while (true) {
      for (int d = 0; d < 4; d++) {
        for (int count = 0; count < moveCount[d]; count++) {
          int nextR = recentR + dr[d];
          int nextC = recentC + dc[d];

          if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
            return totalOutSand;
          }

          int sand = map[nextR][nextC];
          map[nextR][nextC] = 0;
          int remainSand = sand;

          for (int spread = 0; spread < 9; spread++) {
            int spreadR = nextR + spreadDr[d][spread];
            int spreadC = nextC + spreadDc[d][spread];
            int spreadSand = sand * ratio[spread] / 100;

            if (spreadR < 0 || spreadR >= N || spreadC < 0 || spreadC >= N) {
              totalOutSand += spreadSand;
            } else {
              map[spreadR][spreadC] += spreadSand;
            }
            remainSand -= spreadSand;
          }

          int aR = nextR + dr[d];
          int aC = nextC + dc[d];

          if (aR < 0 || aR >= N || aC < 0 || aC >= N) {
            totalOutSand += remainSand;
          } else {
            map[aR][aC] += remainSand;
          }

          recentR = nextR;
          recentC = nextC;
        }
      }
      for (int i = 0; i < moveCount.length; i++) {
        moveCount[i] += 2;
      }
    }
  }

}
