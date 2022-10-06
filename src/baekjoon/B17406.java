package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17406 {

  static int N, M;
  static int K;
  static int[][] arr;
  static boolean[] isVisited;
  static Rotate[] permutationRotate;
  static Rotate[] rotates;

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NMK = br.readLine().split(" ");
    N = Integer.parseInt(NMK[0]);
    M = Integer.parseInt(NMK[1]);
    K = Integer.parseInt(NMK[2]);

    arr = new int[N][M];
    isVisited = new boolean[K];
    permutationRotate = new Rotate[K];
    rotates = new Rotate[K];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(row[j]);
      }
    }

    for (int i = 0; i < K; i++) {
      String[] rcs = br.readLine().split(" ");
      int r = Integer.parseInt(rcs[0]);
      int c = Integer.parseInt(rcs[1]);
      int s = Integer.parseInt(rcs[2]);
      rotates[i] = new Rotate(new int[]{r - s - 1, c - s - 1}, new int[]{r + s - 1, c + s - 1});
    }

    permutation(0);
    System.out.println(min);
  }

  static void permutation(int depth){
    if (depth == K) {
      int[][] tmp = new int[N][M];

      for (int i = 0; i < N; i++) {
        tmp[i] = arr[i].clone();
      }

      for (Rotate rotate : permutationRotate) {
        rotation(tmp, rotate.leftTop, rotate.rightDown);
      }

      cal(tmp);
    }

    for (int i = 0; i < K; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        permutationRotate[depth] = rotates[i];
        permutation(depth + 1);
        isVisited[i] = false;
      }
    }
  }

  static void rotation(int[][] tmp, int[] leftTop, int[] rightDown) {
    int row1 = leftTop[0];
    int col1 = leftTop[1];
    int row2 = rightDown[0];
    int col2 = rightDown[1];

    int temp1 = tmp[row1][col2];
    int temp2 = tmp[row2][col2];
    int temp3 = tmp[row2][col1];

    if (row1 == row2 && col1 == col2) {
      return;
    }

    for (int i = col2; i > col1 ; i--) {
      tmp[row1][i] = tmp[row1][i - 1];
    }

    for (int i = row2; i > row1 ; i--) {
      if(i-1 == row1){
        tmp[i][col2] = temp1;
        continue;
      }
      tmp[i][col2] = tmp[i-1][col2];
    }

    for (int i = col1; i < col2 ; i++) {
      if(i+1 == col2){
        tmp[row2][i] = temp2;
        continue;
      }
      tmp[row2][i] = tmp[row2][i+1];
    }

    for (int i = row1; i < row2 ; i++) {
      if(i+1 == row2){
        tmp[i][col1] = temp3;
        continue;
      }
      tmp[i][col1] = tmp[i+1][col1];
    }

    rotation(tmp, new int[]{row1 + 1, col1 + 1}, new int[]{row2 - 1, col2 - 1});
  }

  static void cal(int[][] tmp){
    for (int i = 0; i < N; i++) {
      int sum = 0;
      for (int j = 0; j < M; j++) {
        sum += tmp[i][j];
      }
      min = Math.min(min, sum);
    }
  }

  static class Rotate {

    int[] leftTop;
    int[] rightDown;

    public Rotate(int[] leftTop, int[] rightDown) {
      this.leftTop = leftTop;
      this.rightDown = rightDown;
    }
  }
}
