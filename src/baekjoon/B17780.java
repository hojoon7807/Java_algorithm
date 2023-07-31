package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B17780 {

  private static int n, k;
  private static int[][] chess;
  private static ArrayList<Integer>[][] moveState;
  private static Horse[] horses;
  private static int[] dr = {0, 0, -1, 1};
  private static int[] dc = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    k = Integer.parseInt(input[1]);

    chess = new int[n][n];
    moveState = new ArrayList[n][n];
    horses = new Horse[k];

    for (int i = 0; i < n; i++) {
      chess[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        moveState[i][j] = new ArrayList<>();
      }
    }

    for (int i = 0; i < k; i++) {
      int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      horses[i] = new Horse(ints[0] - 1, ints[1] - 1, ints[2] - 1);
      moveState[horses[i].r][horses[i].c].add(i);
    }

    System.out.println(move());
  }

  private static int move() {
    int count = 0;

    while (count <= 1000) {
      count++;
      for (int i = 0; i < k; i++) {
        Horse horse = horses[i];
        // 맨아래가 아니면 다음
        if (moveState[horse.r][horse.c].get(0) != i) {
          continue;
        }

        int nr = horse.r + dr[horse.dir];
        int nc = horse.c + dc[horse.dir];
        // 파란색 || 경계
        if (nr < 0 || nr >= n || nc < 0 || nc >= n || chess[nr][nc] == 2) {
          horse.changeDir();
          nr = horse.r + dr[horse.dir];
          nc = horse.c + dc[horse.dir];
        }
        // 반대가 경계나 파란색
        if (nr < 0 || nr >= n || nc < 0 || nc >= n || chess[nr][nc] == 2) {
          continue;
        }
        // 흰색
        else if (chess[nr][nc] == 0) {
          ArrayList<Integer> state = moveState[horse.r][horse.c];
          // 위치 이동하고
          for (Integer index : state) {
            horses[index].r = nr;
            horses[index].c = nc;
          }
          //위에 올림
          int size = state.size();

          for (int j = 0; j < size; j++) {
            moveState[nr][nc].add(state.get(j));
          }

          state.clear();
        }
        // 빨간색
        else if (chess[nr][nc] == 1) {
          ArrayList<Integer> state = moveState[horse.r][horse.c];
          // 위치 이동하고
          for (Integer index : state) {
            horses[index].r = nr;
            horses[index].c = nc;
          }
          int size = state.size();
          // 반대로 올림
          for (int j = 0; j < size; j++) {
            moveState[nr][nc].add(state.get(size - j - 1));
          }
          state.clear();
        }

        if (moveState[nr][nc].size() >= 4) {
          return count;
        }
      }
    }
    return -1;
  }

  private static class Horse {

    int r, c, dir;

    public Horse(int r, int c, int dir) {
      this.r = r;
      this.c = c;
      this.dir = dir;
    }

    public void changeDir() {
      if (dir == 0) {
        dir = 1;
      } else if (dir == 1) {
        dir = 0;
      } else if (dir == 2) {
        dir = 3;
      } else {
        dir = 2;
      }
    }
  }
}
