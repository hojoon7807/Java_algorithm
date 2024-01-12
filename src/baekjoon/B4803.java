package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B4803 {

  static int[] parent;
  static int n, m;
  static Set<Integer> cycleSet = new HashSet<>();
  static Set<Integer> treeSet = new HashSet<>();
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws IOException {
    solution();
  }

  static void solution() throws IOException {
    StringBuilder sb = new StringBuilder();
    int testCase = 1;

    while (true) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) {
        break;
      }

      parent = new int[n + 1];

      for (int i = 0; i <= n; i++) {
        parent[i] = i;
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        union(a, b);
      }

      for (int i = 1; i <= n; i++) {
        int root = find(i);

        if (cycleSet.contains(root)) {
          continue;
        } else {
          treeSet.add(root);
        }
      }

      if (treeSet.size() == 1) {
        sb.append("Case ").append(testCase).append(": There is one tree.").append("\n");
      } else if (treeSet.size() == 0) {
        sb.append("Case ").append(testCase).append(": No trees.").append("\n");
      } else {
        sb.append("Case ").append(testCase).append(": A forest of ").append(treeSet.size())
          .append(" trees.").append("\n");
      }

      treeSet.clear();
      cycleSet.clear();
      testCase++;
    }
    System.out.println(sb);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) {
      cycleSet.add(a);
      cycleSet.add(b);
      return;
    }

    if (cycleSet.contains(a) || cycleSet.contains(b)) {
      cycleSet.add(a);
      cycleSet.add(b);
    }

    if (a != b) {
      parent[b] = a;
    }
  }

  static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
//
//  static boolean isCycle(int parent, int node) {
//    isVisited[node] = true;
//    boolean flag = false;
//    for (Integer next : graph.get(node)) {
//      if (!isVisited[next]) {
//        isVisited[next] = true;
//        flag = isCycle(node, next);
//      } else {
//        if (next != parent) {
//          flag = true;
//        }
//      }
//    }
//    return flag;
//  }


}
