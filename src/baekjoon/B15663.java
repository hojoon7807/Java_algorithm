package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15663 {

  static int n, m;
  static int[] arr;
  static boolean[] isVisited;
  static int[] selected;
  static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    String[] input = br.readLine().split(" ");

    arr = new int[n];
    isVisited = new boolean[n];
    selected = new int[m];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    per(0);

    System.out.println(sb);
  }

  public static void per(int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(selected[i]).append(" ");
      }

      sb.append("\n");
      return;
    }

    int lastSelect = -1;
    for (int i = 0; i < n; i++) {
      if (isVisited[i]) {
        continue;
      }

      if (lastSelect == arr[i]) {
        continue;
      }

      lastSelect = arr[i];
      isVisited[i] = true;
      selected[depth] = arr[i];
      per(depth + 1);
      isVisited[i] = false;
    }
  }

}
