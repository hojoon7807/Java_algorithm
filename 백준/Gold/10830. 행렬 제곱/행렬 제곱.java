
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static long b;
  static int[][] matrix;

  public static void main(String[] args) throws Exception {
    String[] input = br.readLine().split(" ");

    n = Integer.parseInt(input[0]);
    b = Long.parseLong(input[1]);

    matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(input[j]);
      }
    }

    int[][] result = split(b);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(result[i][j] % 1000).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int[][] split(long pivot) {
    if (pivot == 1) {
      return matrix;
    }

    long mid = pivot / 2;

    int[][] tmp = split(mid);
    // n == 5
    // 2,3 -> 1,1 + 1,2 ->
    if (pivot % 2 == 0) {
      return cal(tmp, tmp);
    } else {
      return cal(tmp, cal(tmp, matrix));
    }
  }

  static int[][] cal(int[][] a, int[][] b) {
    int[][] result = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
        result[i][j] %= 1000;
      }
    }

    return result;
  }
}

