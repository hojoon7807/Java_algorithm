import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int INF = 123456789;
  static int[] dist;

  /*
  1 -> N 까지 최소의 비용으로 이동해야한다 -> 다익스크라 알고리즘 사용
   */

  public static void main(String[] args) throws IOException {
    String[] nm = br.readLine().split(" ");

    n = Integer.parseInt(nm[0]);
    m = Integer.parseInt(nm[1]);

    dist = new int[n + 1];
    Arrays.fill(dist, INF);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      int c = Integer.parseInt(input[2]);

      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    dijkstra();

    System.out.println(dist[n]);
  }

  static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    dist[1] = 0;
    pq.add(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.cost > dist[cur.to]) {
        continue;
      }

      for (Node next : graph.get(cur.to)) {
        int nextDist = next.cost + cur.cost;

        if (dist[next.to] > nextDist) {
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
