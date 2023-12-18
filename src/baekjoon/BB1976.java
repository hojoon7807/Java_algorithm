package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BB1976 {

  static int n, m;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    parent = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= n; i++) {
      String[] input = br.readLine().split(" ");

      for (int j = 1; j <= n; j++) {
        int to = Integer.parseInt(input[j - 1]);
        if (to != 0) {
          union(i, j);
        }
      }
    }

    int[] path = new int[m];
    String[] pathInput = br.readLine().split(" ");

    for (int i = 0; i < m; i++) {
      path[i] = Integer.parseInt(pathInput[i]);
    }

    int start = find(path[0]);

    for (int i = 1; i < m; i++) {
      int next = find(path[i]);
      if (start != next) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  static int find(int x) {
    if (x == parent[x]) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      parent[y] = x;
    }
  }

}
