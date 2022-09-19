package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1780 {

  static int[] count = new int[3];
  static int[][] papers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    papers = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] tmp = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        papers[i][j] = Integer.parseInt(tmp[j]);
      }
    }
    splitPaper(0, 0, N);

    for (int i = 0; i < 3; i++) {
      System.out.println(count[i]);
    }
  }

  static boolean isSame(int row, int col, int size) {
    int num = papers[row][col];
    for (int i = row; i < row + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (num != papers[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static void splitPaper(int row, int col, int size) {
    if (isSame(row, col, size)) {
      count[papers[row][col]+1]++;
    } else {
      int s = size / 3;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          splitPaper(row + i * s, col + j * s, s);
        }
      }
    }
  }
}
