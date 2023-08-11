package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금 {

  private static int INF = 987654321;
  private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  public static void main(String[] args) {
    solution(6, 4, 6, 2, new int[][]{
        {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66},
        {2, 3, 22}, {1, 6, 25}
    });
  }

  public static int solution(int n, int s, int a, int b, int[][] fares) {

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < fares.length; i++) {
      int[] fare = fares[i];
      int from = fare[0] - 1;
      int to = fare[1] - 1;
      int weight = fare[2];

      graph.get(from).add(new Node(to, weight));
      graph.get(to).add(new Node(from, weight));
    }

    int[] costTogether = getCost(s - 1, n);

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int[] costEnd = getCost(i, n);
      int cost = costTogether[i] + costEnd[a - 1] + costEnd[b - 1];

      min = Math.min(min, cost);
    }

    return min;
  }

  private static int[] getCost(int start, int n) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
    int[] distance = new int[n];
    Arrays.fill(distance, INF);

    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node recent = pq.poll();

      if (recent.w > distance[recent.to]) {
        continue;
      }

      for (Node next : graph.get(recent.to)) {
        if (distance[next.to] > distance[recent.to] + next.w) {
          distance[next.to] = distance[recent.to] + next.w;
          pq.add(new Node(next.to, distance[next.to]));
        }
      }
    }

    return distance;
  }

  private static class Node {

    int to;
    int w;

    public Node(int to, int w) {
      this.to = to;
      this.w = w;
    }
  }
}
