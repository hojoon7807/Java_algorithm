package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5052 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      String[] addresses = new String[n];
      for (int j = 0; j < n; j++) {
        addresses[j] = br.readLine();
      }

      Arrays.sort(addresses);

      boolean flag = true;
      for (int j = 0; j < n - 1; j++) {
        if (addresses[j + 1].startsWith(addresses[j])) {
          System.out.println("NO");
          flag = false;
          break;
        }
        continue;
      }
      if (flag) {
        System.out.println("YES");
      }
    }
  }
}

