package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2580 {

  private static final int SIZE = 9;
  private static int[][] board = new int[9][9];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input;
    for (int i = 0; i < SIZE; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = Integer.parseInt(input[j]);
      }
    }

    dfs(0, 0);
  }

  private static void dfs(int row, int col) {
    if (row == 9) {
      dfs(0, col + 1);
      return;
    }

    if (col == 9) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          sb.append(board[i][j] + " ");
        }
        sb.append("\n");
      }

      System.out.println(sb);
      System.exit(0);
    }

    if (board[row][col] == 0) {
      for (int i = 1; i <= SIZE; i++) {
        if (isPossible(row, col, i)) {
          board[row][col] = i;
          dfs(row + 1, col);
        }
      }
      board[row][col] = 0;
      return;
    }
    dfs(row + 1, col);

  }

  private static boolean isPossible(int row, int col, int value) {
    for (int i = 0; i < SIZE; i++) {
      if (board[row][i] == value) {
        return false;
      }
    }

    for (int i = 0; i < SIZE; i++) {
      if (board[i][col] == value) {
        return false;
      }
    }

    int secR = (row / 3) * 3;
    int secC = (col / 3) * 3;

    for (int i = secR; i < secR + 3; i++) {
      for (int j = secC; j < secC + 3; j++) {
        if (board[i][j] == value) {
          return false;
        }
      }
    }

    return true;
  }
}
