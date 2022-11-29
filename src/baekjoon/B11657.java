package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B11657 {

  private static class Node {

    int to;
    long w;

    public Node(int to, long w) {
      this.to = to;
      this.w = w;
    }
  }

  static int N, M;
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  static final Long INF = 987654321L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]) - 1;
      int b = Integer.parseInt(input[1]) - 1;
      int c = Integer.parseInt(input[2]);

      graph.get(a).add(new Node(b, c));
    }

    belman(0);
    System.out.println(sb);
  }

  static void belman(int start) {
    boolean existCycle = false;
    long[] dist = new long[N];
    Arrays.fill(dist, INF);

    dist[start] = 0;
//    LinkedList<Node> queue = new LinkedList<>();
//    queue.add(new Node())
    for (int i = 0; i < N; i++) {
      boolean isUpdated = false;
      for (int v = 0; v < N; v++) {
        if (dist[v] == INF) {
          continue;
        }

        for (Node node : graph.get(v)) {
          if (dist[node.to] > dist[v] + node.w) {
            dist[node.to] = dist[v] + node.w;
            isUpdated = true;
          }
        }
      }

      if (!isUpdated) {
        break;
      }

      if (i == N - 1 && isUpdated) {
        existCycle = true;
      }
    }

    if (existCycle) {
      sb.append(-1);
    } else {
      for (int i = start + 1; i < N; i++) {
        if (dist[i] == INF) {
          sb.append(-1 + "\n");
        } else {
          sb.append(dist[i] + "\n");
        }
      }
    }
  }

}
