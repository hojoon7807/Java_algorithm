package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3584 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t, n;
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  static boolean[] isVisited;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    StringBuilder sb = new StringBuilder();
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      isVisited = new boolean[n + 1];

      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }

      for (int i = 0; i < n - 1; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        tree.get(b).add(a);
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      isVisited[node] = true;
      dfs(node);
      isVisited[node2] = true;
      dfs(node2);

      sb.append(answer).append("\n");

      answer = 0;
      tree.clear();
    }

    System.out.println(sb);
  }

  private static void dfs(int v){
    if (tree.get(v).size() == 0) {
      return;
    }

    for (Integer next : tree.get(v)) {
      if (!isVisited[next]) {
        isVisited[next] = true;
        dfs(next);
      } else {
        answer = next;
        return;
      }
    }
  }

}
