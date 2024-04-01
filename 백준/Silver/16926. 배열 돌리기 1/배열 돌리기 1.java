import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int n, m, r;
  static int[][] arr;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String[] nmr = br.readLine().split(" ");
    n = Integer.parseInt(nmr[0]);
    m = Integer.parseInt(nmr[1]);
    r = Integer.parseInt(nmr[2]);

    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int i = 0; i < r; i++) {
      rotate(0,Math.min(n,m) >> 1);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static void rotate(int start, int count) {
    if (start == count) {
      return;
    }

    int tmp = arr[start][start];

    // 위
    for (int i = start; i < m - start - 1; i++) {
      arr[start][i] = arr[start][i + 1];
    }
    // 오
    for (int i = start; i < n - start - 1; i++) {
      arr[i][m - start-1] = arr[i + 1][m - start-1];
    }
    // 아래
    for (int i = m - start - 1; i > start; i--) {
      arr[n - start-1][i] = arr[n - start-1][i - 1];
    }
    // 왼
    for (int i = n - start - 1; i > start; i--) {
      arr[i][start] = arr[i - 1][start];
    }

    arr[start + 1][start] = tmp;
    rotate(start + 1, count);
  }

}
