package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1238 {
  private static int INF = 123456789;
  private static int max = Integer.MIN_VALUE;
  private static int[] distance;
  private static int[] reverseDistance;

  public static void main(String[] args) throws IOException {
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int n = input[0];
    int m = input[1];
    int x = input[2] -1 ;

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
      reverseGraph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int a = input[0]-1;
      int b = input[1]-1;
      int weight = input[2];

      graph.get(a).add(new Node(b, weight));
      reverseGraph.get(b).add(new Node(a, weight));
    }
    distance = new int[n];
    reverseDistance = new int[n];
    Arrays.fill(distance, INF);
    Arrays.fill(reverseDistance, INF);

    dijkstra(x, distance, graph);
    dijkstra(x, reverseDistance, reverseGraph);

    for (int i = 0; i < n; i++) {
      max = Math.max(max, distance[i] + reverseDistance[i]);
    }

    System.out.println(max);

  }

  private static void dijkstra(int start, int[] distance, ArrayList<ArrayList<Node>> graph){
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node recent = pq.poll();

      if (recent.w > distance[recent.v]) {
        continue;
      }

      for (Node next : graph.get(recent.v)) {
        if (distance[recent.v] + next.w < distance[next.v]) {
          distance[next.v] = distance[recent.v] + next.w;
          pq.add(new Node(next.v, distance[next.v]));
        }
      }
    }
  }

  private static class Node {
    int v;
    int w;

    public Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

}
