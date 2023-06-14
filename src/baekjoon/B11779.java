package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class B11779 {

  private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
  private static int INF = 123456789;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    int M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      int from = Integer.parseInt(input[0]);
      int to = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);

      graph.get(from).add(new Edge(to, weight));
    }

    String[] input = br.readLine().split(" ");
    int start = Integer.parseInt(input[0]);
    int end = Integer.parseInt(input[1]);

    System.out.println(dijkstra(start, end));
  }

  private static String dijkstra(int start, int end) {
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
    int[] distance = new int[graph.size()];
    Arrays.fill(distance, INF);
    int[] path = new int[graph.size()];
    pq.add(new Edge(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
      Edge recent = pq.poll();
      if (recent.v == end) {
        break;
      }
      if (recent.w > distance[recent.v]) {
        continue;
      }

      for (Edge next : graph.get(recent.v)) {
        if (next.w + distance[recent.v] < distance[next.v]) {
          distance[next.v] = next.w + distance[recent.v];
          path[next.v] = recent.v;
          pq.add(new Edge(next.v, distance[next.v]));
        }
      }
    }
    StringBuilder answer = new StringBuilder();
    answer.append(distance[end] + "\n");

    Stack<Integer> stack = new Stack<>();
    for (int i = end; i > 0; i = path[i]) {
      stack.add(i);
    }
    answer.append(stack.size() + "\n");
    while (!stack.isEmpty()) {
      answer.append(stack.pop() + " ");
    }

    return answer.toString();
  }

  private static class Edge {

    int v;
    int w;

    public Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
}
