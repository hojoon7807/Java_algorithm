package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2448 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static char[][] board;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    N = Integer.parseInt(br.readLine());
  }

  static void solution() {
    int bottomCount = N / 3;
    int totalLen = bottomCount * 5 + bottomCount - 1;
    board = new char[N][totalLen];

    for (char[] arr : board) {
      Arrays.fill(arr, ' ');
    }

    StringBuilder sb = new StringBuilder();

    recur(N - 1, 0, totalLen - 1, bottomCount);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < totalLen; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void recur(int row, int start, int end, int count) {
    if (count == 1) {
      draw(row, start);
      return;
    }

    int mid = (start + end) / 2;
    int nextCount = count/2;

    int len = (nextCount * 5 + nextCount - 1)/2;

    recur(row, start, mid-1, nextCount);
    recur(row, mid + 1, end, nextCount);
    recur(row -nextCount*3, mid - len, mid + len, nextCount);
  }

  static void draw(int row, int start) {
    for (int i = row; i > row - 3; i--) {
      for (int j = start; j <= start + 4; j++) {
        if (i % 3 == 2) {
          board[i][j] = '*';
        } else if (i % 3 == 1) {
          if ((j - start) % 2 == 1) {
            board[i][j] = '*';
          }
        } else {
          if (j - start == 2) {
            board[i][j] = '*';
          }
        }
      }
    }
  }

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
//    int n = Integer.parseInt(br.readLine());
//
//    star = new char[n][2 * n - 1];
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < 2 * n - 1; j++) {
//        star[i][j] = ' ';
//      }
//    }
//
//    loop(n, 0, n - 1);
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < 2 * n - 1; j++) {
//        sb.append(star[i][j]);
//      }
//      sb.append("\n");
//    }
//    System.out.println(sb);
//  }
//
//  static void loop(int cnt, int y, int x) {
//    if (cnt == 3) {
//      star[y][x] = '*';
//      star[y + 1][x - 1] = star[y + 1][x + 1] = '*';
//      star[y + 2][x - 2] = star[y + 2][x - 1] = star[y + 2][x] = star[y + 2][x + 1] = star[y + 2][x + 2] = '*';
//      return;
//    }
//    int size = cnt / 2;
//    loop(size, y, x);
//    loop(size, y + size, x + size);
//    loop(size, y + size, x - size);
//  }

}
