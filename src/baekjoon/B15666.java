package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15666 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    Arrays.sort(arr);
    dfs(0, 0, "");
    System.out.println(sb);
  }

  static void dfs(int depth, int index, String s) {
    if (depth == m) {
      sb.append(s).append("\n");
      return;
    }

    int start = 0;
    for (int i = index; i < n; i++) {
      if (start != arr[i]) {
        start = arr[i];
        dfs(depth + 1, i, s + arr[i] + " ");
      }
    }
  }

  static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    arr = new int[n];

    input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }
  }

}
