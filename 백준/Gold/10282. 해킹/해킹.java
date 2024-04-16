import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t;
  static int n, d, c;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();
  static int INF = 123456789;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String[] ndc = br.readLine().split(" ");

      n = Integer.parseInt(ndc[0]);
      d = Integer.parseInt(ndc[1]);
      c = Integer.parseInt(ndc[2]);

      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }

      dist = new int[n + 1];

      Arrays.fill(dist, INF);

      for (int i = 0; i < d; i++) {
        String[] abs = br.readLine().split(" ");

        int a = Integer.parseInt(abs[0]);
        int b = Integer.parseInt(abs[1]);
        int s = Integer.parseInt(abs[2]);

        graph.get(b).add(new Node(a, s));
      }

      dijkstra(c);
      addAnswer();
      graph.clear();
    }

    System.out.println(sb);

  }

  static void addAnswer() {
    int max = -1;
    int count = 0;
    for (int d : dist) {
      if (d != INF) {
        count++;
        max = Math.max(max, d);
      }
    }

    sb.append(count).append(" ").append(max).append("\n");
  }

  static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.cost > dist[cur.to]) {
        continue;
      }

      for (Node next : graph.get(cur.to)) {
        int nextDist = next.cost + cur.cost;

        if (nextDist < dist[next.to]) {
          dist[next.to] = nextDist;
          pq.add(new Node(next.to, nextDist));
        }
      }
    }
  }

  static class Node {

    int to;
    int cost;

    public Node(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

}
