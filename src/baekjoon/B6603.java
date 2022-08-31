package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6603 {

  static int k;
  static int[] s;
  static boolean[] isVisited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String string = br.readLine();
      if (string.equals("0")) {
        break;
      }
      String[] strings = string.split(" ");
      k = Integer.parseInt(strings[0]);
      s = new int[k];
      isVisited = new boolean[k];
      for (int i = 0; i < k; i++) {
        s[i] = Integer.parseInt(strings[i + 1]);
      }
      dfs(0, 0);
      System.out.println();
    }
  }

  static void dfs(int index, int depth) {
    if (depth == 6) {
      for (int i = 0; i < k; i++) {
        if (isVisited[i]) {
          System.out.print(s[i] + " ");
        }
      }
      System.out.println();
    }

    for (int i = index; i < k; i++) {
      if (isVisited[i]) {
        continue;
      }
      isVisited[i] = true;
      dfs(i + 1, depth + 1);
      isVisited[i] = false;
    }
  }

}
