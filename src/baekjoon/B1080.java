package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1080 {

  static int[][] matA;
  static int[][] matB;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    matA = new int[N][M];
    matB = new int[N][M];

    int count = 0;

    for (int i = 0; i < N; i++) {
      String[] a = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        matA[i][j] = Integer.parseInt(a[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      String[] b = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        matB[i][j] = Integer.parseInt(b[j]);
      }
    }

    if (N < 3 || M < 3) {
      if (isSame()) {
        System.out.println(0);
        return;
      }
      System.out.println(-1);
      return;
    }

    for (int i = 0; i < N - 2; i++) {
      for (int j = 0; j < M - 2; j++) {
        if (matA[i][j] != matB[i][j]){
          count++;
          flip(i, j);
        }
      }
    }

    if (!isSame()) {
      count = -1;
    }
    System.out.println(count);
  }

  static void flip(int sc, int sr) {
    for (int i = sc; i < sc + 3; i++) {
      for (int j = sr; j < sr + 3; j++) {
        matA[i][j] = matA[i][j] ^ 1;
      }
    }
  }

  static boolean isSame() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matA[i][j] != matB[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
