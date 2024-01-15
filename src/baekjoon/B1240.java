package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1240 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
  static int answer = 0;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    input();
    for (int i = 0; i < m; i++) {
      answer = 0;
      solution();
    }

    System.out.println(sb);
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n + 1; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      tree.get(a).add(new int[]{b, distance});
      tree.get(b).add(new int[]{a, distance});
    }
  }

  static void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());

    dfs(to, from, 0, -1);
    sb.append(answer).append("\n");

  }

  static void dfs(int to, int node, int sum, int parent) {
    if (to == node) {
      answer = sum;
      return;
    }

    for (int[] next : tree.get(node)) {
      int v = next[0];
      int dist = next[1];

      if (v != parent) {
        dfs(to, v, sum + dist, node);
      }
    }
  }

}
