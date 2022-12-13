package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class B3190 {

  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};

  static int[][] map;
  static HashMap<Integer, String> timeInfo = new HashMap<>();
  static LinkedList<int[]> snake = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    map = new int[N][N];

    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      String[] input = br.readLine().split(" ");
      int r = Integer.parseInt(input[0]) - 1;
      int c = Integer.parseInt(input[1]) - 1;

      map[r][c] = 1;
    }

    //snake[0][0] = 1;
    snake.add(new int[]{0, 0});

    map[0][0] = 2;
    int L = Integer.parseInt(br.readLine());

    int direct = 0;
    int count = 0;

    int[] head = new int[]{0, 0};

    for (int i = 0; i < L; i++) {
      String[] XC = br.readLine().split(" ");
      int X = Integer.parseInt(XC[0]);
      String C = XC[1];

      timeInfo.put(X, C);
    }

    while (true) {
      int nr = head[0] + dr[direct];
      int nc = head[1] + dc[direct];
      count++;

      if (nr < 0 || nr >= N || nc < 0 || nc >= N
          || map[nr][nc] == 2) {
        break;
      }

      if (map[nr][nc] != 1) {
        int[] tail = snake.pollFirst();
        map[tail[0]][tail[1]] = 0;
      }
      head = new int[]{nr, nc};
      snake.add(head);
      map[nr][nc] = 2;

      if (timeInfo.containsKey(count)) {
        if (timeInfo.get(count).equals("L")) {
          if (direct == 0) {
            direct = 3;
          } else {
            direct--;
          }
        } else {
          if (direct == 3) {
            direct = 0;
          } else {
            direct++;
          }
        }
      }
    }

    System.out.println(count);
  }

}
