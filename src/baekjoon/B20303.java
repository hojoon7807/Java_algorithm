package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B20303 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, k;
  static int[] candies;
  static int[] parent;
  static int[] dp;
  static HashMap<Integer, int[]> map = new HashMap<>();

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void solution() {
    addGroup();
    for (int[] info : map.values()) {
      int count = info[0];
      int candy = info[1];

      for (int j = k - 1; j >= count; j--) {
        dp[j] = Math.max(dp[j], dp[j - count] + candy);
      }
    }

    System.out.println(dp[k - 1]);
  }

  static void addGroup() {
    for (int i = 1; i <= n; i++) {
      map.putIfAbsent(parent[i], new int[]{0, 0});
      int[] info = map.get(parent[i]);
      info[0]++;
      info[1] += candies[i];
    }
  }

  static void input() throws IOException {
    String[] nmk = br.readLine().split(" ");
    n = Integer.parseInt(nmk[0]);
    m = Integer.parseInt(nmk[1]);
    k = Integer.parseInt(nmk[2]);

    candies = new int[n + 1];
    parent = new int[n + 1];
    dp = new int[k];

    String[] input = br.readLine().split(" ");
    for (int i = 1; i <= n; i++) {
      candies[i] = Integer.parseInt(input[i - 1]);
    }

    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      union(a, b);
    }
  }

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return;
    }

    if (x < y) {
      parent[y] = x;
    } else {
      parent[x] = y;
    }
  }
}
