package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15651 {

  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    StringBuilder sb = new StringBuilder();
    search(0, sb, "");
    System.out.println(sb);
  }

  static void search(int depth, StringBuilder sb, String nums) {
    if (depth == m) {
      sb.append(nums).append("\n");
      return;
    }

    for (int i = 1; i <= n; i++) {
      search(depth + 1, sb, nums + i + " ");
    }
  }

}
