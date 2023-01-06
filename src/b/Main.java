package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] rec;

  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    rec = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        rec[i][j] = Integer.parseInt(line[j]);
      }
    }

    System.out.println(splitPaper(0,0,N));
  }
  static boolean isSame(int row, int col, int size) {
    int num = rec[row][col];
    for (int i = row; i < row + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (num != rec[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static String splitPaper(int row, int col, int size) {
    StringBuilder stringBuilder = new StringBuilder();
    if (isSame(row, col, size)) {
      stringBuilder.append(rec[row][col]);
    } else {
      int s = size / 2;
      stringBuilder.insert(0, "(");
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          stringBuilder.append(splitPaper(row + i * s, col + j * s, s));
        }
      }
      stringBuilder.append(")");
    }
    return stringBuilder.toString();
  }
}
