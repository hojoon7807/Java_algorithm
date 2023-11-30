package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10836 {
  static int m, n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] mn = br.readLine().split(" ");
    m = Integer.parseInt(mn[0]);
    n = Integer.parseInt(mn[1]);

    // 1,000,000 * 1,400

    int[] seq = new int[2 * m - 1];

    Arrays.fill(seq, 1);

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");

      int zero = Integer.parseInt(input[0]);
      int one = Integer.parseInt(input[1]);
      int two = Integer.parseInt(input[2]);
      int index = zero;

      for (int j = index; j < index + one; j++) {
        seq[j] += 1;
      }

      index += one;
      for (int j = index; j < index + two; j++) {
        seq[j] += 2;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = m - 1; i >= 0; i--) {
      sb.append(seq[i]).append(" ");
      for (int j = m; j < 2 * m - 1; j++) {
        sb.append(seq[j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
