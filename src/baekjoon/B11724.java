package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724 {

  static int n,m;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] isVisited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    isVisited = new boolean[n];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int u = Integer.parseInt(input[0])-1;
      int v = Integer.parseInt(input[1])-1;

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        answer ++;
        dfs(i);
      }
    }

    System.out.println(answer);
  }

  static void dfs(int node) {
    isVisited[node] = true;

    for (Integer next : graph.get(node)) {
      if (!isVisited[next]) {
        dfs(next);
      }
    }
  }
}
