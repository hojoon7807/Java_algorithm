package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11725 {
  private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  private static boolean[] isVisited;
  private static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    isVisited = new boolean[N + 1];
    result = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    dfs(1);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(result[i] + "\n");
    }

    System.out.println(sb);
  }

  private static void dfs(int node) {
    isVisited[node] = true;

    for (Integer next : tree.get(node)) {
      if (!isVisited[next]) {
        result[next] = node;
        dfs(next);
      }

    }
  }

}
