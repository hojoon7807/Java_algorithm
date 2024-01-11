package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15900 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static boolean[] isVisited;
  static int winCount = 0;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    solution();
  }

  static void solution() throws IOException {
    isVisited = new boolean[n + 1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    dfs(0, 1);

    System.out.println(winCount % 2 == 0 ? "No" : "Yes");
  }

  static void dfs(int count, int node) {
    isVisited[node] = true;
    boolean isLeaf = true;

    for (Integer next : graph.get(node)) {
      if (!isVisited[next]) {
        isLeaf = false;
        dfs(count + 1, next);
        continue;
      }
    }

    if (isLeaf) {
      winCount += count;
    }
  }

}
