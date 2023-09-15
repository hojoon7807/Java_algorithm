package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15652 {

  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);
    StringBuilder sb = new StringBuilder();
    search(sb, "", 0, 1);
    System.out.println(sb);
  }

  static void search(StringBuilder sb, String nums, int depth, int start) {
    if (depth == m) {
      sb.append(nums).append("\n");
      return;
    }

    for (int i = start; i <= n; i++) {
      search(sb, nums + i + " ", depth + 1, i);
    }
  }

}
