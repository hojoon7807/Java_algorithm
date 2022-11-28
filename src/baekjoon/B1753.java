package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B1753 {

  static int V, E;
  static final int INF = 987654321;
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();


  private static class Node {

    int to;
    int w;

    public Node(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] VE = br.readLine().split(" ");

    V = Integer.parseInt(VE[0]);
    E = Integer.parseInt(VE[1]);

    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    int S = Integer.parseInt(br.readLine());

    for (int i = 0; i < E; i++) {
      String[] uvw = br.readLine().split(" ");
      int u = Integer.parseInt(uvw[0]);
      int v = Integer.parseInt(uvw[1]);
      int w = Integer.parseInt(uvw[2]);

      graph.get(u - 1).add(new Node(v - 1, w));
    }

    dijkstar(S - 1);

    System.out.println(sb);
  }

  static void dijkstar(int start) {
    int[] dist = new int[V];
    Arrays.fill(dist, INF);

    dist[start] = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    queue.add(new Node(start, dist[start]));

    while (!queue.isEmpty()) {
      Node recent = queue.poll();
      int v = recent.to;
      int d = recent.w;

      if (d > dist[v]) {
        continue;
      }

      for (Node node : graph.get(v)) {
        if (dist[node.to] > node.w + dist[v]) {
          dist[node.to] = node.w + dist[v];
          queue.add(new Node(node.to, dist[node.to]));
        }
      }
    }
    for (int i = 0; i < V; i++) {
      if (dist[i] == INF) {
        sb.append("INF" + "\n");
      } else {
        sb.append(dist[i] + "\n");
      }
    }
  }
}
