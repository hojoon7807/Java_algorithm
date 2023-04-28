package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12100 {

  private static int N;
  private static int[][] map;
  private static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    game(0);
    System.out.println(max);
  }

  private static void game(int count) {
    if (count == 5) {
      findMax();
      return;
    }
    int[][] tmp = new int[N][N];

    for (int i = 0; i < N; i++) {
      tmp[i] = map[i].clone();
    }

    for (int i = 0; i < 4; i++) {
      switch (i) {
        case 0:
          moveLeft();
          break;
        case 1:
          moveRight();
          break;
        case 2:
          moveUp();
          break;
        case 3:
          moveDown();
          break;
        default:
          break;
      }

      game(count +1);
      for (int j = 0; j < N; j++) {
        map[j] = tmp[j].clone();
      }
    }
  }

  private static void moveLeft(){
    for (int i = 0; i < N; i++) {
      int index = 0;
      int lastMoved = 0;
      for (int j = 0; j < N; j++) {
        if (map[i][j] != 0) {
          if(lastMoved == map[i][j]) {
            map[i][index -1] *= 2;
            lastMoved = 0;
            map[i][j] = 0;
          } else {
            lastMoved = map[i][j];
            map[i][j] = 0;
            map[i][index] = lastMoved;
            index ++;
          }
        }
      }
    }
  }

  private static void moveRight(){
      for (int i = 0; i < N; i++) {
        int index = N - 1;
        int lastMoved = 0;
        for (int j = N-1; j >= 0; j--) {
          if (map[i][j] != 0) {
            if(lastMoved == map[i][j]) {
              map[i][index +1] *= 2;
              lastMoved = 0;
              map[i][j] = 0;
            } else {
              lastMoved = map[i][j];
              map[i][j] = 0;
              map[i][index] = lastMoved;
              index --;
            }
          }
        }
      }
  }

  private static void moveUp(){
    for (int i = 0; i < N; i++) {
      int index = 0;
      int lastMoved = 0;
      for (int j = 0; j < N; j++) {
        if (map[j][i] != 0) {
          if(lastMoved == map[j][i]) {
            map[index -1][i] *= 2;
            lastMoved = 0;
            map[j][i] = 0;
          } else {
            lastMoved = map[j][i];
            map[j][i] = 0;
            map[index][i] = lastMoved;
            index ++;
          }
        }
      }
    }
  }

  private static void moveDown(){
    for (int i = 0; i < N; i++) {
      int index = N - 1;
      int lastMoved = 0;
      for (int j = N-1; j >= 0; j--) {
        if (map[j][i] != 0) {
          if(lastMoved == map[j][i]) {
            map[index+1][i] *= 2;
            lastMoved = 0;
            map[j][i] = 0;
          } else {
            lastMoved = map[j][i];
            map[j][i] = 0;
            map[index][i] = lastMoved;
            index --;
          }
        }
      }
    }
  }

  private static void findMax(){
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        max = Math.max(max, map[i][j]);
      }
    }
  }
}
