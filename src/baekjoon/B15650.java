package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650 {

  static int n, m;
  static boolean[] nums;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    nums = new boolean[n + 1];

    makeSequence(0, 1);

    System.out.println(sb);

  }

  private static void makeSequence(int depth, int index) {
    if (depth == m) {
      for (int i = 1; i <= n; i++) {
        if (nums[i]) {
          sb.append(i + " ");
        }
      }
      sb.append("\n");
      return;
    }

    for (int i = index; i <= n; i++) {
      nums[i] = true;
      makeSequence(depth + 1, i + 1);
      nums[i] = false;
    }
  }

}
