package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {

  static int n;
  static int[] chess;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    chess = new int[n];

    locateQueen(0);

    System.out.println(count);
  }

  private static void locateQueen(int depth) {
    if (depth == n) {
      count++;
      return;
    }

    for (int i = 0; i < n; i++) {
      chess[depth] = i;

      if (canLocate(depth)) {
        locateQueen(depth + 1);
      }
    }
  }

  private static boolean canLocate(int row) {
    for (int i = 0; i < row; i++) {
      if (chess[row] == chess[i] || Math.abs(row - i) == Math.abs(chess[row] - chess[i])) {
        return false;
      }
    }
    return true;
  }


}
