package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11728 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    int[] a = new int[n];
    int[] b = new int[m];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(input[i]);
    }

    input = br.readLine().split(" ");

    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(a);
    Arrays.sort(b);

    StringBuilder sb = new StringBuilder();

    int aP = 0;
    int bP = 0;

    while (aP < n || bP < m) {
      if (aP >= n) {
        for (int i = bP; i < m; i++) {
          sb.append(b[i]).append(" ");
        }

        break;
      }

      if (bP >= m) {
        for (int i = aP; i < n; i++) {
          sb.append(a[i]).append(" ");
        }

        break;
      }
      int aV = a[aP];
      int bV = b[bP];

      if (aV < bV) {
        sb.append(aV).append(" ");
        aP++;
      } else {
        sb.append(bV).append(" ");
        bP++;
      }
    }

    System.out.println(sb);
  }

}
