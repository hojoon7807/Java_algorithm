
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n, m;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] arr;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    arr = new char[n][m];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i <= n - 8; i++) {
      for (int j = 0; j <= m - 8; j++) {
        startBlack(i, j);
        startWhite(i, j);
      }
    }

    System.out.println(min);

  }

  static void startBlack(int r, int c) {
    int count = 0;
    for (int i = r; i < r + 8; i++) {
      for (int j = c; j < c + 8; j++) {
        if (((i - r) & 1) == 0) {
          if (((j - c) & 1) == 0) {
            if (arr[i][j] != 'B') {
              count++;
            }
          } else {
            if (arr[i][j] != 'W') {
              count++;
            }
          }
        } else {
          if (((j - c) & 1) == 0) {
            if (arr[i][j] != 'W') {
              count++;
            }
          } else {
            if (arr[i][j] != 'B') {
              count++;
            }
          }
        }
      }
    }

    min = Math.min(min, count);
  }

  static void startWhite(int r, int c) {
    int count = 0;
    for (int i = r; i < r + 8; i++) {
      for (int j = c; j < c + 8; j++) {
        if (((i - r) & 1) == 0) {
          if (((j - c) & 1) == 0) {
            if (arr[i][j] != 'W') {
              count++;
            }
          } else {
            if (arr[i][j] != 'B') {
              count++;
            }
          }
        } else {
          if (((j - c) & 1) == 0) {
            if (arr[i][j] != 'B') {
              count++;
            }
          } else {
            if (arr[i][j] != 'W') {
              count++;
            }
          }
        }
      }
    }

    min = Math.min(min, count);
  }
}
