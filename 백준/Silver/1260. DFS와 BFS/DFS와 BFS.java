
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, v;
  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] isVisited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    String[] nmv = br.readLine().split(" ");
    n = Integer.parseInt(nmv[0]);
    m = Integer.parseInt(nmv[1]);
    v = Integer.parseInt(nmv[2]);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    isVisited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 0; i <= n; i++) {
      Collections.sort(graph.get(i));
    }

    dfs(v);
    sb.append("\n");
    isVisited = new boolean[n + 1];
    bfs(v);
    System.out.println(sb);

  }

  static void dfs(int node){
    isVisited[node] = true;
    sb.append(node).append(" ");
    for (Integer next : graph.get(node)) {
      if(!isVisited[next]){
        dfs( next);
      }
    }
  }

  static void bfs(int node){
    isVisited[node] = true;
    sb.append(node).append(" ");
    LinkedList<Integer> q = new LinkedList<>();
    q.add(node);

    while (!q.isEmpty()) {
      int cur = q.poll();



      for (Integer next : graph.get(cur)) {
        if (!isVisited[next]) {
          isVisited[next] = true;
          sb.append(next).append(" ");
          q.add(next);
        }
      }
    }
  }

}
