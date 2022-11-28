package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B1916 {

  private static class Edge {

    int to;
    int w;

    public Edge(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }

  static int N, M;
  static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
  static int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      int cost = Integer.parseInt(input[2]);

      graph.get(a-1).add(new Edge(b-1, cost));
    }

    String[] input = br.readLine().split(" ");
    int start = Integer.parseInt(input[0]);
    int end = Integer.parseInt(input[1]);

    System.out.println(dijkstra(start-1, end-1));
  }

  static int dijkstra(int start, int end) {
    PriorityQueue<Edge> queue = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);

    int[] dist = new int[N];
    Arrays.fill(dist, INF);
    dist[start] = 0;
    queue.add(new Edge(start, dist[start]));

    while (!queue.isEmpty()) {
      Edge recent = queue.poll();
      int v = recent.to;
      int d = recent.w;

      if (d > dist[v]) continue;

      for (Edge edge : graph.get(v)) {
        if (checkMin(dist[edge.to], dist[v] + edge.w)) {
          dist[edge.to] = dist[v] + edge.w;
          queue.add(new Edge(edge.to, dist[edge.to]));
        }
      }
    }
    return dist[end];
  }

  static boolean checkMin(int a, int b) {
    if (a > b) {
      return true;
    } else {
      return false;
    }
  }
}
