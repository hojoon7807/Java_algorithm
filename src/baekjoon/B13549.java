package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B13549 {

  private static int[] arr = new int[100001];
  private static int n, k;
  private static int[] distance = new int[100001];
  private static int INF = Integer.MAX_VALUE;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    k = Integer.parseInt(input[1]);

    Arrays.fill(distance, INF);

    dijkstra(n, k);

    System.out.println(distance[k]);
  }

  private static void dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.w));

    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node recent = pq.poll();

      if (recent.w > distance[recent.to]) {
        continue;
      }

      int move1 = recent.to - 1;
      int move2 = recent.to + 1;
      int move3 = recent.to * 2;

      if (move1 >= 0 && distance[move1] > distance[recent.to] + 1) {
        distance[move1] = distance[recent.to] + 1;
        pq.add(new Node(move1, distance[move1]));
      }

      if (move2 < 100001 && distance[move2] > distance[recent.to] + 1) {
        distance[move2] = distance[recent.to] + 1;
        pq.add(new Node(move2, distance[move2]));
      }

      if (move3 < 100001 && distance[move3] > distance[recent.to]) {
        distance[move3] = distance[recent.to];
        pq.add(new Node(move3, distance[move3]));
      }
    }
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
