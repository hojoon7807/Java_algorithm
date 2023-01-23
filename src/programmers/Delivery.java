package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Delivery {

  private static class Edge {

    int to;
    int w;

    public Edge(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }

  static final Integer INF = 123456789;
  public int solution(int N, int[][] road, int K) {
    int answer = 0;

    ArrayList<ArrayList<Edge>> graph = new ArrayList();

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<Edge>());
    }

    for (int i = 0; i < road.length; i++) {
      int a= road[i][0];
      int b= road[i][1];
      int c = road[i][2];
      graph.get(a-1).add(new Edge(b-1, c));
      graph.get(b-1).add(new Edge(a-1, c));
    }

    int[] dist = dijkstra(N, graph);

    for (int i = 0; i < N; i ++) {
      if (dist[i] <= K) {
        answer ++;
      }
    }
    return answer;
  }
  
  int[] dijkstra(int n, ArrayList<ArrayList<Edge>> graph){
    int[] dist = new int[n];
    Arrays.fill(dist, INF);

    dist[0] = 0;

    PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    queue.add(new Edge(0, dist[0]));

    while(!queue.isEmpty()) {
      Edge recent = queue.poll();
      int v = recent.to;
      int d = recent.w;

      if (d > dist[v]) {
        continue;
      }

      for (Edge next : graph.get(v)) {
        if (dist[next.to] > next.w + dist[v]) {
          dist[next.to] = next.w + dist[v];
          queue.add(new Edge(next.to, dist[next.to]));
        }
      }
    }
    return dist;
  }

}
