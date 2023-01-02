package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2533 {

  static int N;
  static int[][] dp;
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }

    dp = new int[N + 1][2];

    for (int i = 0; i < N - 1; i++) {
      String[] split = br.readLine().split(" ");
      int u = Integer.parseInt(split[0]);
      int v = Integer.parseInt(split[1]);

      tree.get(u).add(v);
      tree.get(v).add(u);
    }

    dfs(-1, 1);

    System.out.println(Math.min(dp[1][0], dp[1][1]));
  }

  static void dfs(int parent, int current) {
    dp[current][0] = 0;
    dp[current][1] = 1;

    for (int child : tree.get(current)) {
      if (parent != child) {
        dfs(current, child);
        dp[current][0] += dp[child][1];
        dp[current][1] += Math.min(dp[child][1], dp[child][0]);
      }
    }
  }

}
