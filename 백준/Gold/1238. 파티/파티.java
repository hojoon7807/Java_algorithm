import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  static int INF = 123456789;
  static int max = Integer.MIN_VALUE;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  /*
  X 로 갔다가 다시 돌아오는 최댓값

  각 위치에서 X로 가는 최단거리가 아니라 X 에서 각 위치로 이동하는 최단거리를 구한다
  양방향 체크를 위해 2개의 그래프를 두고 각각 다익스트라
  각위치의 왕복 거리 최댓값 구하기
   */
  public static void main(String[] args) throws IOException {
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int n = input[0];
    int m = input[1];
    int x = input[2] - 1;

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
      reverseGraph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int a = input[0] - 1;
      int b = input[1] - 1;
      int weight = input[2];

      graph.get(a).add(new Node(b, weight));
      reverseGraph.get(b).add(new Node(a, weight));
    }

    int[] distance = new int[n];
    int[] reverseDistance = new int[n];
    Arrays.fill(distance, INF);
    Arrays.fill(reverseDistance, INF);

    dijkstra(x, distance, graph);
    dijkstra(x, reverseDistance, reverseGraph);

    for (int i = 0; i < n; i++) {
      max = Math.max(max, distance[i] + reverseDistance[i]);
    }

    System.out.println(max);

  }

  static void dijkstra(int start, int[] distance, ArrayList<ArrayList<Node>> graph) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.w > distance[cur.v]) {
        continue;
      }

      for (Node next : graph.get(cur.v)) {
        if (cur.w + next.w < distance[next.v]) {
          distance[next.v] = cur.w + next.w;
          pq.add(new Node(next.v, distance[next.v]));
        }
      }
    }
  }

  static class Node {

    int v;
    int w;

    public Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

}
